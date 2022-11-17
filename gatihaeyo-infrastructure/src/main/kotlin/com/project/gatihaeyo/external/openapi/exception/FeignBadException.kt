package com.project.gatihaeyo.external.openapi.exception

import com.project.gatihaeyo.external.openapi.error.FeignErrorCode.BAD_REQUEST
import com.project.gatihaeyo.global.GlobalException

class FeignBadException private constructor() : GlobalException(BAD_REQUEST) {

    companion object {
        @JvmField
        val EXCEPTION = FeignBadException()
    }

}