package com.project.gatihaeyo.internal.user.error

import com.project.gatihaeyo.global.error.ErrorProperty
import com.project.gatihaeyo.global.error.HttpStatus

enum class UserErrorCode(
    private val httpStatus: HttpStatus,
    private val message: String
) : ErrorProperty {

    ALREADY_FOLLOW(HttpStatus.CONFLICT, "이미 팔로우되어있습니다."),

    CANNOT_FOLLOW_ALONE(HttpStatus.BAD_REQUEST, "혼자 팔로우를 할 순 없습니다."),

    DIFFERENT_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다."),

    FOLLOW_NOT_FOUND(HttpStatus.NOT_FOUND, "팔로우를 찾을 수 없습니다."),
    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "계정을 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다.");

    override fun getMessage() = message

    override fun getStatus() = httpStatus.status
}