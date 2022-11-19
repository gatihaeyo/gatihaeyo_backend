package com.project.gatihaeyo.internal.user.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.user.error.UserErrorCode.FOLLOW_NOT_FOUND

class FollowNotFoundException private constructor() : GlobalException(FOLLOW_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = FollowNotFoundException()
    }
}