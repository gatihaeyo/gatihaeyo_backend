package com.project.gatihaeyo.internal.domain.exception.auth

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.auth.AuthErrorCode

class AuthCodeMismatchException private constructor() : GlobalException(AuthErrorCode.AUTHCODE_MISMATCH) {

    companion object {
        @JvmField
        val EXCEPTION = AuthCodeMismatchException()
    }

}