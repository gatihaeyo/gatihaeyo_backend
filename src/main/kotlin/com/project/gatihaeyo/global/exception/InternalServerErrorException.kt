package com.project.gatihaeyo.global.exception

import com.project.gatihaeyo.global.error.GlobalErrorCode
import com.project.gatihaeyo.global.error.GlobalException

class InternalServerErrorException private constructor() : GlobalException(GlobalErrorCode.INTERNAL_SERVER_ERROR) {

    companion object {
        @JvmField
        val EXCEPTION = InternalServerErrorException()
    }

}