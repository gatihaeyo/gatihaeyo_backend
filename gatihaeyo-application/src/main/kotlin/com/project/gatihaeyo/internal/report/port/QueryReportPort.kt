package com.project.gatihaeyo.internal.report.port

import com.project.gatihaeyo.internal.report.ReportType
import com.project.gatihaeyo.internal.report.model.Report
import java.util.UUID

interface QueryReportPort {

    fun queryReportList(size: Long, last: Long?, type: ReportType?): List<Report>

    fun existsReportByUserIdAndReportUserId(userId: UUID, reportUserId: UUID): Boolean
}