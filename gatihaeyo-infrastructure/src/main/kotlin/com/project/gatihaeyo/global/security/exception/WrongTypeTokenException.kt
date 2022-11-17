package com.project.gatihaeyo.global.security.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.global.security.error.SecurityErrorCode.WRONG_TYPE_TOKEN

class WrongTypeTokenException private constructor() : GlobalException(WRONG_TYPE_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = WrongTypeTokenException()
    }

}