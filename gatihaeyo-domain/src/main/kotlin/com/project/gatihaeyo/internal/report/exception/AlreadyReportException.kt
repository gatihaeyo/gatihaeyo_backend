package com.project.gatihaeyo.internal.report.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.report.error.ReportErrorCode.ALREADY_REPORT_USER

class AlreadyReportException private constructor() : GlobalException(ALREADY_REPORT_USER) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyReportException()
    }
}