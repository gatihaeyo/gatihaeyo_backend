package com.project.gatihaeyo.global.security.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.global.security.error.SecurityErrorCode

class WrongTypeTokenException private constructor() : GlobalException(SecurityErrorCode.WRONG_TYPE_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = WrongTypeTokenException()
    }

}