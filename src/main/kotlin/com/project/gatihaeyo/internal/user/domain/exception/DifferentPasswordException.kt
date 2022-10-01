package com.project.gatihaeyo.internal.user.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.user.domain.error.UserErrorCode

class DifferentPasswordException private constructor() : GlobalException(UserErrorCode.DIFFERENT_PASSWORD) {

    companion object {
        @JvmField
        val EXCEPTION = DifferentPasswordException()
    }

}