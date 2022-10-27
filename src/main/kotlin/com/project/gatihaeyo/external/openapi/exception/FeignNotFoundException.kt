package com.project.gatihaeyo.external.openapi.exception

import com.project.gatihaeyo.external.openapi.error.FeignErrorCode
import com.project.gatihaeyo.global.exception.GlobalException

class FeignNotFoundException private constructor() : GlobalException(FeignErrorCode.NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = FeignNotFoundException()
    }

}