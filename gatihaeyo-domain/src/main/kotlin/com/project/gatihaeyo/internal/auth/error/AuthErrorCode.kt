package com.project.gatihaeyo.internal.auth.error

import com.project.gatihaeyo.global.error.ErrorProperty
import com.project.gatihaeyo.global.error.HttpStatus

enum class AuthErrorCode(
    private val httpStatus: HttpStatus,
    private val message: String
) : ErrorProperty {

    REFRESH_TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "토큰을 찾을 수 없습니다."),
    AUTHCODE_MISMATCH(HttpStatus.UNAUTHORIZED, "인증 코드가 일치하지 않습니다."),
    UNCERTIFIED_EMAIL(HttpStatus.UNAUTHORIZED, "이메일 인증을 먼저 해주세요."),

    ALREADY_USED_NICKNAME(HttpStatus.CONFLICT, "이미 사용된 닉네임입니다."),
    ALREADY_USED_EMAIL(HttpStatus.CONFLICT, "이미 사용된 이메일입니다.");

    override fun getMessage() = message

    override fun getStatus() = httpStatus.status

}