package com.project.gatihaeyo.internal.message.dto.response

import java.time.LocalDateTime
import java.util.UUID

data class ShowMessageResponse(
    val id: UUID,
    val sender: UUID,
    val message: String,
    val timestamp: LocalDateTime
)