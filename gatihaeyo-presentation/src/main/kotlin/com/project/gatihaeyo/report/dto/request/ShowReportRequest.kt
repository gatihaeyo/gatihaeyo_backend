package com.project.gatihaeyo.report.dto.request

import com.project.gatihaeyo.internal.report.RequestReportType
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class ShowReportRequest(
    val last: Long?,

    @field:NotNull
    @field:Positive
    val size: Long,

    val type: RequestReportType?
)