package com.project.gatihaeyo.internal.auth.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.auth.domain.error.AuthErrorCode

class AlreadyUsedEmailException private constructor() : GlobalException(AuthErrorCode.ALREADY_USED_EMAIL) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyUsedEmailException()
    }

}