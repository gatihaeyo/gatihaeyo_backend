package com.project.gatihaeyo.internal.auth.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.user.error.UserErrorCode.DIFFERENT_PASSWORD

class DifferentPasswordException private constructor() : GlobalException(DIFFERENT_PASSWORD) {

    companion object {
        @JvmField
        val EXCEPTION = DifferentPasswordException()
    }

}