package com.project.gatihaeyo.internal.domain.exception.auth

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.user.UserErrorCode

class DifferentPasswordException private constructor() : GlobalException(UserErrorCode.DIFFERENT_PASSWORD) {

    companion object {
        @JvmField
        val EXCEPTION = DifferentPasswordException()
    }

}