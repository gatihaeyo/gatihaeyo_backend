package com.project.gatihaeyo.internal.socket

import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.listener.ConnectListener
import com.corundumstudio.socketio.listener.DisconnectListener
import com.project.gatihaeyo.global.security.token.JwtParser
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.UUID
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

    private val connectListener = (ConnectListener { client ->
        val token = client.handshakeData.getSingleUrlParam("token")

        val currentUserId = UUID.fromString(jwtParser.getAuthentication(token).name)
        client.set("id", currentUserId)

        println("SOCKET :: [${LocalDateTime.now()}] :: [$currentUserId] - CONNECT")
    })

    private val disConnectListener = (DisconnectListener { client ->
        client.disconnect()

        println("SOCKET :: [${LocalDateTime.now()}] :: [${client.get<String>("id")}] - DISCONNECT")
    })

}