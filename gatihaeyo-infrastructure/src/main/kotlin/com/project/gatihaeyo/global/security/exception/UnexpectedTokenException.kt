package com.project.gatihaeyo.global.security.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.global.security.error.SecurityErrorCode.UNEXPECTED_TOKEN

class UnexpectedTokenException private constructor() : GlobalException(UNEXPECTED_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = UnexpectedTokenException()
    }

}