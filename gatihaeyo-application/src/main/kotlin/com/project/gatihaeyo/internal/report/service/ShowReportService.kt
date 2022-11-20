package com.project.gatihaeyo.internal.report.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.report.dto.ShowReportDto
import com.project.gatihaeyo.internal.report.dto.response.ShowReportListResponse
import com.project.gatihaeyo.internal.report.port.QueryReportPort

@ReadOnlyBusinessService
class ShowReportService(
    private val queryReportPort: QueryReportPort
) {

    fun execute(request: ShowReportDto): ShowReportListResponse {
        val (last, size, type) = request

        val list = queryReportPort.queryReportList(
            size = size,
            last = last,
            type = type?.value
        )

        return ShowReportListResponse(
            list.map {
                ShowReportListResponse.ShowReportListElement(
                    id = it.id,
                    type = it.type,
                    content = it.content,
                    reportAt = it.createdAt
                )
            }
        )
    }
}