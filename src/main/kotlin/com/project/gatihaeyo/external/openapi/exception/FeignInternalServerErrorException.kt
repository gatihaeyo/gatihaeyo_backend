package com.project.gatihaeyo.external.openapi.exception

import com.project.gatihaeyo.external.openapi.error.FeignErrorCode
import com.project.gatihaeyo.global.exception.GlobalException

class FeignInternalServerErrorException private constructor() : GlobalException(FeignErrorCode.INTERNAL_SERVER_ERROR) {

    companion object {
        @JvmField
        val EXCEPTION = FeignInternalServerErrorException()
    }

}