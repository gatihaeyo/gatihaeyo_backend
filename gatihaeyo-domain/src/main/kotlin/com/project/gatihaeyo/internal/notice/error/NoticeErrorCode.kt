package com.project.gatihaeyo.internal.notice.error

import com.project.gatihaeyo.global.error.ErrorProperty
import com.project.gatihaeyo.global.error.HttpStatus

enum class NoticeErrorCode(
    private val httpStatus: HttpStatus,
    private val message: String
) : ErrorProperty {

    NOTICE_NOT_FOUND(HttpStatus.NOT_FOUND, "알림을 찾을 수 없습니다.");

    override fun getStatus() = httpStatus.status

    override fun getMessage() = message
}