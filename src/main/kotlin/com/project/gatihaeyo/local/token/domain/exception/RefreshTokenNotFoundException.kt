package com.project.gatihaeyo.local.token.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.local.token.domain.error.RefreshTokenErrorCode

class RefreshTokenNotFoundException private constructor() : GlobalException(RefreshTokenErrorCode.REFRESH_TOKEN_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = RefreshTokenNotFoundException()
    }

}