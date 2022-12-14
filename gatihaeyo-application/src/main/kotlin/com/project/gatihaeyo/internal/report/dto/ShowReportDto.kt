package com.project.gatihaeyo.internal.report.dto

import com.project.gatihaeyo.internal.report.RequestReportType

data class ShowReportDto(
    val last: Long?,

    val size: Long,

    val type: RequestReportType?
)