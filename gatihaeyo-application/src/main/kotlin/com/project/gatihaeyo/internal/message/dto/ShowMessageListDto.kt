package com.project.gatihaeyo.internal.message.dto

import java.util.UUID

data class ShowMessageListDto(
    val roomId: UUID,
    val size: Long,
    val page: Long
)