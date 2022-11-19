package com.project.gatihaeyo.internal.notice.dto

import java.time.LocalDateTime
import java.util.UUID

data class NoticeDto(
    val id: UUID,
    val content: String,
    val noticeAt: LocalDateTime
)