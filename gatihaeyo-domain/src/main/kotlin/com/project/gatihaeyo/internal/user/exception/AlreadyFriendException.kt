package com.project.gatihaeyo.internal.user.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.user.error.UserErrorCode.ALREADY_FOLLOW

class AlreadyFriendException private constructor() : GlobalException(ALREADY_FOLLOW) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyFriendException()
    }
}