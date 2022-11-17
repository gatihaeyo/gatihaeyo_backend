package com.project.gatihaeyo.external.openapi.exception

import com.project.gatihaeyo.external.openapi.error.FeignErrorCode.NOT_FOUND
import com.project.gatihaeyo.global.GlobalException

class FeignNotFoundException private constructor() : GlobalException(NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = FeignNotFoundException()
    }

}