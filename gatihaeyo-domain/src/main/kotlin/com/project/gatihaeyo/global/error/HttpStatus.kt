package com.project.gatihaeyo.global.error

enum class HttpStatus(
    val status: Int
) {

    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    CONFLICT(409),
    INTERNAL_SERVER_ERROR(500)
}