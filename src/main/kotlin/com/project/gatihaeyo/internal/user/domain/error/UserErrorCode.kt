package com.project.gatihaeyo.internal.user.domain.error

import com.project.gatihaeyo.global.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class UserErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    DIFFERENT_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않음"),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없음");

    override fun getMessage() = message

    override fun getStatus() = status.value()
}