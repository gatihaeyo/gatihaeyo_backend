package com.project.gatihaeyo.global.error

import org.springframework.http.HttpStatus

enum class FileErrorCode(
    private val status: HttpStatus,
    private val message: String
): ErrorProperty {

    INVALID_EXTENSION(HttpStatus.BAD_REQUEST, "제한된 확장자(jpg, jpeg, png)"),

    FILE_IO_INTERRUPTED(HttpStatus.INTERNAL_SERVER_ERROR, "파일 입출력 오류");

    override fun getMessage() = message

    override fun getStatus() = status.value()
}