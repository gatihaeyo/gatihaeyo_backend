package com.project.gatihaeyo.internal.domain.exception.user

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.user.UserErrorCode

class FriendNotFoundException private constructor() : GlobalException(UserErrorCode.FRIEND_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = FriendNotFoundException()
    }
}