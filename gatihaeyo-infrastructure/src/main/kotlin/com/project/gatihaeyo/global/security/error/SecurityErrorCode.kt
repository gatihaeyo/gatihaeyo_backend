package com.project.gatihaeyo.global.security.error

import com.project.gatihaeyo.global.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class SecurityErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다."),

    UNEXPECTED_TOKEN(HttpStatus.UNAUTHORIZED, "알 수 없는 토큰입니다."),

    WRONG_TYPE_TOKEN(HttpStatus.UNAUTHORIZED, "유형이 맞지 않는 토큰입니다."),

    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다.");

    override fun getMessage() = message

    override fun getStatus(): Int = status.value()

}