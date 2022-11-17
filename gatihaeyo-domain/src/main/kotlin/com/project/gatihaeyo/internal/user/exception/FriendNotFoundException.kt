package com.project.gatihaeyo.internal.user.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.user.error.UserErrorCode.FRIEND_NOT_FOUND

class FriendNotFoundException private constructor() : GlobalException(FRIEND_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = FriendNotFoundException()
    }
}