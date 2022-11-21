package com.project.gatihaeyo.internal.message.model

import java.time.LocalDateTime
import java.util.UUID

data class Message(
    val id: UUID = UUID(0, 0),
    val roomId: UUID,
    val userId: UUID,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)