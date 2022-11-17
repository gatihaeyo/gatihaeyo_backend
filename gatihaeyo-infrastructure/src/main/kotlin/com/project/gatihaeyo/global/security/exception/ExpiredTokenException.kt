package com.project.gatihaeyo.global.security.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.global.security.error.SecurityErrorCode.EXPIRED_TOKEN

class ExpiredTokenException private constructor() : GlobalException(EXPIRED_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = ExpiredTokenException()
    }

}