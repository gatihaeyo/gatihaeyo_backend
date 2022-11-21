package com.project.gatihaeyo.internal.socket

import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.listener.ConnectListener
import com.corundumstudio.socketio.listener.DisconnectListener
import org.springframework.stereotype.Component
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import javax.annotation.PreDestroy

@Component
class SocketServerSwitch(
    private val socketIOServer: SocketIOServer
) {

    private val connectMap = ConcurrentHashMap<UUID, SocketIOClient>()

    private val connectListener = (ConnectListener { client ->
        val id = UUID.fromString(client.handshakeData.getSingleUrlParam("id"))
        connectMap[id] = client
        client.set("id", id)
    })

    private val disConnectListener = (DisconnectListener { client ->
        val id = client.get<UUID>("id")
        connectMap.remove(id)
        client.disconnect()
    })

    init {
        socketIOServer.apply {
            addConnectListener(connectListener)
            addDisconnectListener(disConnectListener)
        }.start()
    }

    @PreDestroy
    fun destroy() {
        socketIOServer.stop()
    }

}