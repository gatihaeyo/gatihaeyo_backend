package com.project.gatihaeyo.internal.image.error

import com.project.gatihaeyo.global.error.ErrorProperty
import com.project.gatihaeyo.global.error.HttpStatus

enum class FileErrorCode(
    private val httpStatus: com.project.gatihaeyo.global.error.HttpStatus,
    private val message: String
): com.project.gatihaeyo.global.error.ErrorProperty {

    COMPATIBLE_EXTENSION(com.project.gatihaeyo.global.error.HttpStatus.BAD_REQUEST, "호환되는 확장자(jpg, jpeg, png)가 아닙니다."),

    FILE_IO_INTERRUPTED(com.project.gatihaeyo.global.error.HttpStatus.INTERNAL_SERVER_ERROR, "파일 입출력에 문제가 생겼습니다.");

    override fun getMessage() = message

    override fun getStatus() = httpStatus.status
}