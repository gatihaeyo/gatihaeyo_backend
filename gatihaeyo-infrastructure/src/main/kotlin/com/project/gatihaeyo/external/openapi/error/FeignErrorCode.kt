package com.project.gatihaeyo.external.openapi.error

import com.project.gatihaeyo.global.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class FeignErrorCode (
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    UN_AUTHORIZED(HttpStatus.UNAUTHORIZED, "인증되지 않은 요청입니다."),

    NOT_FOUND(HttpStatus.NOT_FOUND, "찾을 수 없습니다."),

    UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "미디어 타입이 잘못되었습니다."),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다.");

    override fun getMessage() = message

    override fun getStatus() = status.value()
}