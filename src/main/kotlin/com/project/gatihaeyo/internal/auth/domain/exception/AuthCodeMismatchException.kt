package com.project.gatihaeyo.internal.auth.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.auth.domain.error.AuthErrorCode

class AuthCodeMismatchException private constructor() : GlobalException(AuthErrorCode.AUTHCODE_MISMATCH) {

    companion object {
        @JvmField
        val EXCEPTION = AuthCodeMismatchException()
    }

}