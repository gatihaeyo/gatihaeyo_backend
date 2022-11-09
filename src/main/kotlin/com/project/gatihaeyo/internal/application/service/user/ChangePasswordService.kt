package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.auth.QueryAuthCodePort
import com.project.gatihaeyo.internal.application.port.user.CommandUserPort
import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.exception.auth.AuthCodeMismatchException
import com.project.gatihaeyo.internal.domain.exception.auth.UncertifiedEmailException
import com.project.gatihaeyo.internal.domain.exception.user.UserNotFoundException
import com.project.gatihaeyo.internal.dto.request.user.ChangePasswordRequest

@BusinessService
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
            user.copy(
                password = securityService.encode(request.newPassword)
            )
        )
    }

}