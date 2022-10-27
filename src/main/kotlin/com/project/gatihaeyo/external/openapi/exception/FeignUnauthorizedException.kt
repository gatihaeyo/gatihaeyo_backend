package com.project.gatihaeyo.external.openapi.exception

import com.project.gatihaeyo.external.openapi.error.FeignErrorCode
import com.project.gatihaeyo.global.exception.GlobalException

class FeignUnauthorizedException private constructor() : GlobalException(FeignErrorCode.UN_AUTHORIZED) {

    companion object {
        @JvmField
        val EXCEPTION = FeignUnauthorizedException()
    }

}