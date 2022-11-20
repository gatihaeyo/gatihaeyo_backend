package com.project.gatihaeyo.report.dto.request

import com.project.gatihaeyo.internal.report.RequestReportType
import java.util.UUID
import javax.validation.constraints.NotNull

data class ReportUserRequest(
    @field:NotNull
    val userId: UUID,

    @field:NotNull
    val type: RequestReportType,

    @field:NotNull
    val content: String
)