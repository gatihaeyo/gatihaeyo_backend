package com.project.gatihaeyo.external.openapi.exception

import com.project.gatihaeyo.external.openapi.error.FeignErrorCode.UNSUPPORTED_MEDIA_TYPE
import com.project.gatihaeyo.global.GlobalException

class FeignUnsupportedMediaTypeException private constructor() : GlobalException(UNSUPPORTED_MEDIA_TYPE) {

    companion object {
        @JvmField
        val EXCEPTION = FeignUnsupportedMediaTypeException()
    }

}