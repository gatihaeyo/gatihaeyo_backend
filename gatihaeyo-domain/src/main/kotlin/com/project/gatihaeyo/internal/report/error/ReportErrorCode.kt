package com.project.gatihaeyo.internal.report.error

import com.project.gatihaeyo.global.error.ErrorProperty
import com.project.gatihaeyo.global.error.HttpStatus

enum class ReportErrorCode(
    private val httpStatus: HttpStatus,
    private val message: String
) : ErrorProperty {

    ALREADY_REPORT_USER(HttpStatus.CONFLICT, "이미 신고한 유저입니다.");

    override fun getStatus() = httpStatus.status

    override fun getMessage() = message

}