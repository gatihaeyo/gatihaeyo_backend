package com.project.gatihaeyo.global.security.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.global.security.error.SecurityErrorCode

class InvalidTokenException private constructor() : GlobalException(SecurityErrorCode.INVALID_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = InvalidTokenException()
    }

}