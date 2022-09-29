package com.project.gatihaeyo.local.user.domain.error

import com.project.gatihaeyo.global.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class UserErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    ALREADY_USED_NICKNAME(HttpStatus.CONFLICT, "이미 사용된 닉네임"),
    ALREADY_USED_EMAIL(HttpStatus.CONFLICT, "이미 사용된 이메일"),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없음");

    override fun getMessage() = message

    override fun getStatus() = status.value()
}