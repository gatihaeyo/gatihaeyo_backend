package com.project.gatihaeyo.internal.message.error

import com.project.gatihaeyo.global.error.ErrorProperty
import com.project.gatihaeyo.global.error.HttpStatus

enum class MessageErrorCode(
    private val httpStatus: HttpStatus,
    private val message: String
) : ErrorProperty {

    MESSAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "메시지를 찾을 수 없습니다.");

    override fun getStatus() = httpStatus.status

    override fun getMessage() = message

}