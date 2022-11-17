package com.project.gatihaeyo.global.security.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.global.security.error.SecurityErrorCode.INVALID_TOKEN

class InvalidTokenException private constructor() : GlobalException(INVALID_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = InvalidTokenException()
    }

}