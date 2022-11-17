package com.project.gatihaeyo.internal.user.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.user.error.UserErrorCode.ALREADY_FRIEND

class AlreadyFriendException private constructor() : GlobalException(ALREADY_FRIEND) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyFriendException()
    }
}