package com.project.gatihaeyo.internal.auth.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.auth.error.AuthErrorCode.AUTHCODE_MISMATCH

class AuthCodeMismatchException private constructor() : GlobalException(AUTHCODE_MISMATCH) {

    companion object {
        @JvmField
        val EXCEPTION = AuthCodeMismatchException()
    }

}