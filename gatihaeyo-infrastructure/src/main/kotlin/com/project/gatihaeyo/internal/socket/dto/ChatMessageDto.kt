package com.project.gatihaeyo.internal.socket.dto

import java.util.UUID

data class ChatMessageDto(
    val roomId: UUID? = null,
    val message: String? = null,
)