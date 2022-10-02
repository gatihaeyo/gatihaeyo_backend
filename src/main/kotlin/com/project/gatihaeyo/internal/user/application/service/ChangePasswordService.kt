package com.project.gatihaeyo.internal.user.application.service

import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.auth.application.port.QueryAuthCodePort
import com.project.gatihaeyo.internal.auth.domain.exception.AuthCodeMismatchException
import com.project.gatihaeyo.internal.auth.domain.exception.UncertifiedEmailException
import com.project.gatihaeyo.internal.user.application.port.CommandUserPort
import com.project.gatihaeyo.internal.user.application.port.QueryUserPort
import com.project.gatihaeyo.internal.user.domain.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.dto.request.ChangePasswordRequest
import org.springframework.stereotype.Service

@Service
class ChangePasswordService(
    private val queryUserPort: QueryUserPort,
    private val commandUserPort: CommandUserPort,
    private val queryAuthCodePort: QueryAuthCodePort,
    private val securityService: SecurityService
) {

    fun execute(request: ChangePasswordRequest) {
        val user = queryUserPort.queryUserByEmail(request.email)
            ?: throw UserNotFoundException.EXCEPTION

        val authCode = queryAuthCodePort.queryAuthCodeByEmail(request.email)
            ?: throw UncertifiedEmailException.EXCEPTION

        if (authCode.code != request.code) {
            throw AuthCodeMismatchException.EXCEPTION
        }

        commandUserPort.save(
            user.updatePassword(
                securityService.encode(request.newPassword)
            )
        )
    }

}