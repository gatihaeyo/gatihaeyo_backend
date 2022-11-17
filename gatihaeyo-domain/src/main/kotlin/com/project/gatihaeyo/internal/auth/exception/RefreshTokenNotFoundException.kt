package com.project.gatihaeyo.internal.auth.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.auth.error.AuthErrorCode.REFRESH_TOKEN_NOT_FOUND

class RefreshTokenNotFoundException private constructor() : GlobalException(REFRESH_TOKEN_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = RefreshTokenNotFoundException()
    }

}