package com.project.gatihaeyo.internal.auth.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.auth.error.AuthErrorCode.UNCERTIFIED_EMAIL

class UncertifiedEmailException private constructor() : GlobalException(UNCERTIFIED_EMAIL) {

    companion object {
        @JvmField
        val EXCEPTION = UncertifiedEmailException()
    }

}