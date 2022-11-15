package com.project.gatihaeyo.internal.domain.error.user

import com.project.gatihaeyo.global.error.ErrorProperty
import org.springframework.http.HttpStatus

enum class UserErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    ALREADY_FRIEND(HttpStatus.CONFLICT, "이미 친구추가되어있습니다."),

    CANNOT_MAKE_FRIEND_ALONE(HttpStatus.BAD_REQUEST, "혼자 친구를 만들 순 없습니다."),

    DIFFERENT_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다."),

    FRIEND_NOT_FOUND(HttpStatus.NOT_FOUND, "친구를 찾을 수 없습니다."),
    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "계정을 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다.");

    override fun getMessage() = message

    override fun getStatus() = status.value()
}