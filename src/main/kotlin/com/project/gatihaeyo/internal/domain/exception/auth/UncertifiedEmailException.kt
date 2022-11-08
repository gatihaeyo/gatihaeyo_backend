package com.project.gatihaeyo.internal.domain.exception.auth

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.auth.AuthErrorCode

class UncertifiedEmailException private constructor() : GlobalException(AuthErrorCode.UNCERTIFIED_EMAIL) {

    companion object {
        @JvmField
        val EXCEPTION = UncertifiedEmailException()
    }

}