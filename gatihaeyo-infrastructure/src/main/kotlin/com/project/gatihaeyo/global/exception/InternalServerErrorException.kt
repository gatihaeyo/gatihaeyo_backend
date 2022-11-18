package com.project.gatihaeyo.global.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.global.error.GlobalErrorCode.INTERNAL_SERVER_ERROR

class InternalServerErrorException private constructor() : GlobalException(INTERNAL_SERVER_ERROR) {

    companion object {
        @JvmField
        val EXCEPTION = InternalServerErrorException()
    }

}