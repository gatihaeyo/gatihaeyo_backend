package com.project.gatihaeyo.external.openapi.exception

import com.project.gatihaeyo.external.openapi.error.FeignErrorCode
import com.project.gatihaeyo.global.exception.GlobalException

class FeignBadException private constructor() : GlobalException(FeignErrorCode.BAD_REQUEST) {

    companion object {
        @JvmField
        val EXCEPTION = FeignBadException()
    }

}