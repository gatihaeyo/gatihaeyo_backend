package com.project.gatihaeyo.internal.auth.application.service

import com.project.gatihaeyo.internal.auth.application.port.QueryAuthCodePort
import com.project.gatihaeyo.internal.auth.domain.exception.AuthCodeMismatchException
import com.project.gatihaeyo.internal.auth.domain.exception.UncertifiedEmailException
import com.project.gatihaeyo.internal.auth.dto.request.VerifiedAuthCodeRequest
import org.springframework.stereotype.Service

@Service
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