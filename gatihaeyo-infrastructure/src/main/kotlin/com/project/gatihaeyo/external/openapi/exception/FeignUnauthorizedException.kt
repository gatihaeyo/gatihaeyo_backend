package com.project.gatihaeyo.external.openapi.exception

import com.project.gatihaeyo.external.openapi.error.FeignErrorCode.UN_AUTHORIZED
import com.project.gatihaeyo.global.GlobalException

class FeignUnauthorizedException private constructor() : GlobalException(UN_AUTHORIZED) {

    companion object {
        @JvmField
        val EXCEPTION = FeignUnauthorizedException()
    }

}