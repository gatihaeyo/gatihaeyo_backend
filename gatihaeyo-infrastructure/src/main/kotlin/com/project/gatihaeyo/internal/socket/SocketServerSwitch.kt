package com.project.gatihaeyo.internal.socket

import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.listener.ConnectListener
import com.corundumstudio.socketio.listener.DisconnectListener
import com.project.gatihaeyo.global.security.token.JwtParser
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import javax.annotation.PostConstruct

@Component
class SocketServerSwitch(
    private val socketIOServer: SocketIOServer,
    private val jwtParser: JwtParser
) {

    @PostConstruct
    protected fun init() {
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

        println("SOCKET :: [${LocalDateTime.now()}] :: [$currentUserId] - CONNECT")
    })

    private val disConnectListener = (DisconnectListener { client ->
        val currentUserId: UUID = client.get("id")
        connectMap[currentUserId] = client
        client.disconnect()

        println("SOCKET :: [${LocalDateTime.now()}] :: [${currentUserId}] - DISCONNECT")
    })

}