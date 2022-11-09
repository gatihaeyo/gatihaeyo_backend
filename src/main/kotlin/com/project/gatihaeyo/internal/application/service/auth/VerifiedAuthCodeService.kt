package com.project.gatihaeyo.internal.application.service.auth

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.application.port.auth.QueryAuthCodePort
import com.project.gatihaeyo.internal.domain.exception.auth.AuthCodeMismatchException
import com.project.gatihaeyo.internal.domain.exception.auth.UncertifiedEmailException
import com.project.gatihaeyo.internal.dto.request.auth.VerifiedAuthCodeRequest

@ReadOnlyBusinessService
class VerifiedAuthCodeService(
    private val queryAuthCodePort: QueryAuthCodePort
) {

    fun execute(request: VerifiedAuthCodeRequest) {
        val authCode = queryAuthCodePort.queryAuthCodeByEmail(request.email)
            ?: throw UncertifiedEmailException.EXCEPTION

        if(authCode.code != request.code) {
            throw AuthCodeMismatchException.EXCEPTION
        }
    }

}