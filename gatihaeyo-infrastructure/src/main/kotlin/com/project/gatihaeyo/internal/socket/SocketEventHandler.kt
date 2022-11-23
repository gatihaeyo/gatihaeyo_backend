package com.project.gatihaeyo.internal.socket

import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.SocketIONamespace
import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.listener.ConnectListener
import com.corundumstudio.socketio.listener.DataListener
import com.corundumstudio.socketio.listener.DisconnectListener
import com.project.gatihaeyo.global.security.token.JwtParser
import com.project.gatihaeyo.internal.message.dto.response.ShowMessageResponse
import com.project.gatihaeyo.internal.message.implement.MessageFacade
import com.project.gatihaeyo.internal.message.model.Message
import com.project.gatihaeyo.internal.socket.dto.ChatMessageDto
import com.project.gatihaeyo.internal.socket.exception.MessageNullException
import com.project.gatihaeyo.internal.team.exception.TeamMemberNotFoundException
import com.project.gatihaeyo.internal.team.implement.TeamMemberFacade
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

@Component
class SocketEventHandler(
    socketIOServer: SocketIOServer,
    private val jwtParser: JwtParser,
    private val teamMemberFacade: TeamMemberFacade,
    private val messageFacade: MessageFacade
) {

    init {
        socketIOServer.apply {
            addConnectListener(connectListener)
            addDisconnectListener(disConnectListener)
        }.start()
    }

    private val connectMap = ConcurrentHashMap<UUID, SocketIOClient>()

    private val connectListener = (ConnectListener { client ->
        val token = client.handshakeData.getSingleUrlParam("token")

        val currentUserId = UUID.fromString(jwtParser.getAuthentication(token).name)

        connectMap[currentUserId] = client
        client.set("id", currentUserId)
    })

    private val disConnectListener = (DisconnectListener { client ->
        val id = client.get<UUID>("id")
        connectMap.remove(id)
        client.disconnect()
    })

    private val socketIONamespace: SocketIONamespace = socketIOServer.addNamespace("/chat").apply {
        addEventListener("send", ChatMessageDto::class.java, onMessage())
        addEventListener("join", UUID::class.java, onJoin())
        addEventListener("leave", UUID::class.java, onLeave())
    }

    private fun onMessage() : DataListener<ChatMessageDto> {
        return (DataListener { client, data, _ ->
            if (data.message == null || data.roomId == null) {
                throw MessageNullException.EXCEPTION
            }

            val userId: UUID = client.get("id")

            val message = messageFacade.saveMessage(
                Message(
                    roomId = data.roomId,
                    message = data.message,
                    userId = userId
                )
            )

            val response = ShowMessageResponse(
                id = message.id,
                sender = userId,
                message = message.message,
                timestamp = message.createdAt
            )

            socketIONamespace.getRoomOperations(data.roomId.toString()).sendEvent("message", client, response)

            println("SOCKET :: [{${LocalDateTime.now()}}] :: [$userId] - MESSAGE ${data.message}")
        })
    }

    private fun onJoin() : DataListener<UUID> {
        return (DataListener { client, data, _ ->
            if (data == null) {
                throw MessageNullException.EXCEPTION
            }

            val userId: UUID = client.get("id")

            if (!teamMemberFacade.existsTeamMemberByUserIdAndTeamId(userId, data)) {
                throw TeamMemberNotFoundException.EXCEPTION
            }

            client.joinRoom(data.toString())

            println("SOCKET :: [{${LocalDateTime.now()}}] :: [$userId] - JOIN ROOM $data")
        })
    }

    private fun onLeave() : DataListener<UUID> {
        return (DataListener { client, data, _ ->
            client.leaveRoom(data.toString())

            println("SOCKET :: [{${LocalDateTime.now()}}] :: [${client.get<String>("id")}] - LEAVE ROOM $data")
        })
    }

}