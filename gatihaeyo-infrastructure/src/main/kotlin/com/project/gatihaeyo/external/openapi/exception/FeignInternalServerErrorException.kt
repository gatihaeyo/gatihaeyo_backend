package com.project.gatihaeyo.external.openapi.exception

import com.project.gatihaeyo.external.openapi.error.FeignErrorCode.INTERNAL_SERVER_ERROR
import com.project.gatihaeyo.global.GlobalException

class FeignInternalServerErrorException private constructor() : GlobalException(INTERNAL_SERVER_ERROR) {

    companion object {
        @JvmField
        val EXCEPTION = FeignInternalServerErrorException()
    }

}