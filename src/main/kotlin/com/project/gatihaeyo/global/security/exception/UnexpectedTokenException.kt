package com.project.gatihaeyo.global.security.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.global.security.error.SecurityErrorCode

class UnexpectedTokenException private constructor() : GlobalException(SecurityErrorCode.UNEXPECTED_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = UnexpectedTokenException()
    }

}