package com.project.gatihaeyo.internal.domain.exception.user

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.user.UserErrorCode

class UserNotFoundException private constructor() : GlobalException(UserErrorCode.USER_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }

}
