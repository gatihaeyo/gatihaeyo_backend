package com.project.gatihaeyo.external.openapi.error

import com.project.gatihaeyo.external.openapi.exception.FeignBadException
import com.project.gatihaeyo.external.openapi.exception.FeignInternalServerErrorException
import com.project.gatihaeyo.external.openapi.exception.FeignNotFoundException
import com.project.gatihaeyo.external.openapi.exception.FeignUnauthorizedException
import com.project.gatihaeyo.external.openapi.exception.FeignUnsupportedMediaTypeException
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder

class FeignErrorHandler : ErrorDecoder {

    override fun decode(methodKey: String, response: Response): Exception {
        when(response.status()) {
            400 -> throw FeignBadException.EXCEPTION
            401 -> throw FeignUnauthorizedException.EXCEPTION
            404 -> throw FeignNotFoundException.EXCEPTION
            415 -> throw FeignUnsupportedMediaTypeException.EXCEPTION
            500 -> throw FeignInternalServerErrorException.EXCEPTION
        }

        return FeignException.errorStatus(methodKey, response)
    }
}