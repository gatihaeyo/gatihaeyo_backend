package com.project.gatihaeyo.global.exception

import com.project.gatihaeyo.global.error.GlobalErrorCode

class InternalServerErrorException private constructor() : GlobalException(GlobalErrorCode.INTERNAL_SERVER_ERROR) {

    companion object {
        @JvmField
        val EXCEPTION = InternalServerErrorException()
    }

}