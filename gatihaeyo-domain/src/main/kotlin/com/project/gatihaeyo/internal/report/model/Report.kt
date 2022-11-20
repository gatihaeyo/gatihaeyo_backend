package com.project.gatihaeyo.internal.report.model

import com.project.gatihaeyo.internal.report.ReportType
import java.time.LocalDateTime
import java.util.UUID

data class Report(
    val id: Long = 0,

    val type: ReportType,

    val content: String,

    val userId: UUID,

    val reportUserId: UUID,

    val createdAt: LocalDateTime = LocalDateTime.now()
)