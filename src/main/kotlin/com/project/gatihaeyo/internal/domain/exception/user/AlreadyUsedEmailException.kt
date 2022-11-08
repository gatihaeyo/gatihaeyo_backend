package com.project.gatihaeyo.internal.domain.exception.user

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.auth.AuthErrorCode

class AlreadyUsedEmailException private constructor() : GlobalException(AuthErrorCode.ALREADY_USED_EMAIL) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyUsedEmailException()
    }

}