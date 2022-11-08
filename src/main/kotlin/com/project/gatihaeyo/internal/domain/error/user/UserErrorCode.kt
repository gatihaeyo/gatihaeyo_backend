package com.project.gatihaeyo.internal.domain.error.user

import com.project.gatihaeyo.global.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class UserErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    DIFFERENT_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다."),

    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "계정을 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다.");

    override fun getMessage() = message

    override fun getStatus() = status.value()
}