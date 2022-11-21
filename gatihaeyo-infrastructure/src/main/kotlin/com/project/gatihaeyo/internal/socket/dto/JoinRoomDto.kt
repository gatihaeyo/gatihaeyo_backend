package com.project.gatihaeyo.internal.socket.dto

import java.util.UUID

data class JoinRoomDto(
    val token: String,
    val roomId: UUID
)