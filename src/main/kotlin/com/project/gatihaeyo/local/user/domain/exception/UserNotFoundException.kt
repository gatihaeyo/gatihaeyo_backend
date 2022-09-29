package com.project.gatihaeyo.local.user.domain.exception

import com.project.gatihaeyo.global.error.GlobalException
import com.project.gatihaeyo.local.user.domain.error.UserErrorCode

class UserNotFoundException private constructor() : GlobalException(UserErrorCode.USER_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }

}
