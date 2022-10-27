package com.project.gatihaeyo.external.openapi.exception

import com.project.gatihaeyo.external.openapi.error.FeignErrorCode
import com.project.gatihaeyo.global.exception.GlobalException

class FeignUnsupportedMediaTypeException private constructor() : GlobalException(FeignErrorCode.UNSUPPORTED_MEDIA_TYPE) {

    companion object {
        @JvmField
        val EXCEPTION = FeignUnsupportedMediaTypeException()
    }

}