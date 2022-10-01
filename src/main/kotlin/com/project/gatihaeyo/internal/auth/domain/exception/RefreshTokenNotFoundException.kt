package com.project.gatihaeyo.internal.auth.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.auth.domain.error.AuthErrorCode

class RefreshTokenNotFoundException private constructor() : GlobalException(AuthErrorCode.REFRESH_TOKEN_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = RefreshTokenNotFoundException()
    }

}