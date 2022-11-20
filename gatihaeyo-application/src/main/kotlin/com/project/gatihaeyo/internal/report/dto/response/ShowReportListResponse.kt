package com.project.gatihaeyo.internal.report.dto.response

import com.project.gatihaeyo.internal.report.ReportType
import java.time.LocalDateTime

data class ShowReportListResponse(
    val list: List<ShowReportListElement>
) {
    data class ShowReportListElement(
        val id: Long,

        val type: ReportType,

        val content: String,

        val reportAt: LocalDateTime
    )
}