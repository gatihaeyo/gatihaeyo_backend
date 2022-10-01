package com.project.gatihaeyo.internal.user.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.user.domain.error.UserErrorCode

class UserNotFoundException private constructor() : GlobalException(UserErrorCode.USER_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }

}
