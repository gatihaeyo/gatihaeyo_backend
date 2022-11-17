package com.project.gatihaeyo.internal.auth.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.auth.dto.VerifiedAuthCodeDto
import com.project.gatihaeyo.internal.auth.exception.AuthCodeMismatchException
import com.project.gatihaeyo.internal.auth.exception.UncertifiedEmailException
import com.project.gatihaeyo.internal.auth.port.QueryAuthCodePort

@ReadOnlyBusinessService
class VerifiedAuthCodeService(
    private val queryAuthCodePort: QueryAuthCodePort
) {

    fun execute(request: VerifiedAuthCodeDto) {
        val authCode = queryAuthCodePort.queryAuthCodeByEmail(request.email)
            ?: throw UncertifiedEmailException.EXCEPTION

        if(authCode.code != request.code) {
            throw AuthCodeMismatchException.EXCEPTION
        }
    }

}