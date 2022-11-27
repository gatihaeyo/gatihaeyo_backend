package com.project.gatihaeyo.global.config

import com.corundumstudio.socketio.SocketConfig
import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.listener.DefaultExceptionListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SocketIoConfig {

    @Bean
    fun socketIOServer() : SocketIOServer {
        val configuration = com.corundumstudio.socketio.Configuration().apply {
            socketConfig = SocketConfig()
            port = 10027
            origin = "*"
            exceptionListener = DefaultExceptionListener()
        }

        return SocketIOServer(configuration)
    }
}