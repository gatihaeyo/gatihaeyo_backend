package com.project.gatihaeyo.internal.domain.exception.user

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.user.UserErrorCode

class AlreadyFriendException private constructor() : GlobalException(UserErrorCode.ALREADY_FRIEND) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyFriendException()
    }
}