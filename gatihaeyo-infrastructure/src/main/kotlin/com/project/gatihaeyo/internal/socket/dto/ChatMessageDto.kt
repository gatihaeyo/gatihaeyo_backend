package com.project.gatihaeyo.internal.socket.dto

import java.util.UUID

data class ChatMessageDto(
    val token: String?,
    val roomId: UUID?,
    val message: String?,
)