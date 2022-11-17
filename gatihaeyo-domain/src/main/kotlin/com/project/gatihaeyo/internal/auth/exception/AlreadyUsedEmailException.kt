package com.project.gatihaeyo.internal.auth.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.auth.error.AuthErrorCode.ALREADY_USED_EMAIL

class AlreadyUsedEmailException private constructor() : GlobalException(ALREADY_USED_EMAIL) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyUsedEmailException()
    }

}