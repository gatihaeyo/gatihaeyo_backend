package com.project.gatihaeyo.internal.report.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.report.dto.ReportUserDto
import com.project.gatihaeyo.internal.report.exception.AlreadyReportException
import com.project.gatihaeyo.internal.report.model.Report
import com.project.gatihaeyo.internal.report.port.CommandReportPort
import com.project.gatihaeyo.internal.report.port.QueryReportPort

@BusinessService
class ReportUserService(
    private val queryReportPort: QueryReportPort,
    private val commandReportPort: CommandReportPort,
    private val securityPort: SecurityPort
) {

    fun execute(request: ReportUserDto) {
        val currentUserId = securityPort.getCurrentUserId()
        val (userId, type, content) = request

        if (queryReportPort.existsReportByUserIdAndReportUserId(
                userId = currentUserId,
                reportUserId = userId
        )) {
            throw AlreadyReportException.EXCEPTION
        }

        commandReportPort.saveReport(
            Report(
                type = type.value,
                content = content,
                userId = currentUserId,
                reportUserId = userId,
            )
        )
    }
}