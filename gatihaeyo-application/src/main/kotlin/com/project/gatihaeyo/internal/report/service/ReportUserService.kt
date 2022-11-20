package com.project.gatihaeyo.internal.report.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.report.dto.ReportUserDto
import com.project.gatihaeyo.internal.report.model.Report
import com.project.gatihaeyo.internal.report.port.CommandReportPort

@BusinessService
class ReportUserService(
    private val commandReportPort: CommandReportPort,
    private val securityPort: SecurityPort
) {

    fun execute(request: ReportUserDto) {
        val currentUserId = securityPort.getCurrentUserId()
        val (userId, type, content) = request

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