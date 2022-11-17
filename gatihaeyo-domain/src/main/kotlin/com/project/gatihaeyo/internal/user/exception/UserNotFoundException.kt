package com.project.gatihaeyo.internal.user.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.user.error.UserErrorCode.USER_NOT_FOUND

class UserNotFoundException private constructor() : GlobalException(USER_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }

}
