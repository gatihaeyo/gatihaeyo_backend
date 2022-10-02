package com.project.gatihaeyo.internal.image.domain.error

import com.project.gatihaeyo.global.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class FileErrorCode(
    private val status: HttpStatus,
    private val message: String
): ErrorProperty {

    COMPATIBLE_EXTENSION(HttpStatus.BAD_REQUEST, "호환되는 확장자(jpg, jpeg, png)가 아닙니다."),

    FILE_IO_INTERRUPTED(HttpStatus.INTERNAL_SERVER_ERROR, "파일 입출력에 문제가 생겼습니다.");

    override fun getMessage() = message

    override fun getStatus() = status.value()
}