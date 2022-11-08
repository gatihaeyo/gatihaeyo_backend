package com.project.gatihaeyo.internal.domain.exception.auth

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.auth.AuthErrorCode

class RefreshTokenNotFoundException private constructor() : GlobalException(AuthErrorCode.REFRESH_TOKEN_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = RefreshTokenNotFoundException()
    }

}