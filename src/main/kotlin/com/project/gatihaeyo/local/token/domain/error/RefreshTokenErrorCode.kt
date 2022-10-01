package com.project.gatihaeyo.local.token.domain.error

import com.project.gatihaeyo.global.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class RefreshTokenErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    REFRESH_TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "토큰을 찾을 수 없음");

    override fun getMessage() = message

    override fun getStatus() = status.value()

}