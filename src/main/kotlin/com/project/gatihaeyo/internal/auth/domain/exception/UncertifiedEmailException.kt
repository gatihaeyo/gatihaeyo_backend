package com.project.gatihaeyo.internal.auth.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.auth.domain.error.AuthErrorCode

class UncertifiedEmailException private constructor() : GlobalException(AuthErrorCode.UNCERTIFIED_EMAIL) {

    companion object {
        @JvmField
        val EXCEPTION = UncertifiedEmailException()
    }

}