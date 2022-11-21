package com.project.gatihaeyo.internal.socket

import com.corundumstudio.socketio.SocketIONamespace
import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.listener.DataListener
import com.project.gatihaeyo.global.security.token.JwtParser
import com.project.gatihaeyo.internal.message.dto.response.ShowMessageResponse
import com.project.gatihaeyo.internal.message.implement.MessageFacade
import com.project.gatihaeyo.internal.message.model.Message
import com.project.gatihaeyo.internal.socket.dto.ChatMessageDto
import com.project.gatihaeyo.internal.socket.dto.JoinRoomDto
import com.project.gatihaeyo.internal.team.exception.TeamMemberNotFoundException
import com.project.gatihaeyo.internal.team.implement.TeamMemberFacade
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SocketEventHandler(
    socketIOServer: SocketIOServer,
    private val jwtParser: JwtParser,
    private val teamMemberFacade: TeamMemberFacade,
    private val messageFacade: MessageFacade
) {

    private val socketIONamespace: SocketIONamespace = socketIOServer.addNamespace("/chat").apply {
        addEventListener("send", ChatMessageDto::class.java, onMessage())
        addEventListener("join", JoinRoomDto::class.java, onJoin())
        addEventListener("leave", UUID::class.java, onLeave())
    }

    private fun onMessage() : DataListener<ChatMessageDto> {
        return (DataListener { client, data, _ ->
            val userId = UUID.fromString(
                jwtParser.getAuthentication(data.token).name
            )

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
        })
    }

    private fun onJoin() : DataListener<JoinRoomDto> {
        return (DataListener { client, data, _ ->
            val userId = UUID.fromString(
                jwtParser.getAuthentication(data.token).name
            )

            if (!teamMemberFacade.existsTeamMemberByUserIdAndTeamId(userId, data.roomId)) {
                throw TeamMemberNotFoundException.EXCEPTION
            }

            client.joinRoom(data.roomId.toString())
        })
    }

    private fun onLeave() : DataListener<UUID> {
        return (DataListener { client, data, _ ->
            client.leaveRoom(data.toString())
        })
    }

}