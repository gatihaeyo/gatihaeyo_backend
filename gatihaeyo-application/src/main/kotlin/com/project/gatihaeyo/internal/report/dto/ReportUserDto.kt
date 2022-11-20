package com.project.gatihaeyo.internal.report.dto

import com.project.gatihaeyo.internal.report.RequestReportType
import java.util.UUID

data class ReportUserDto(
    val userId: UUID,

    val type: RequestReportType,

    val content: String
)