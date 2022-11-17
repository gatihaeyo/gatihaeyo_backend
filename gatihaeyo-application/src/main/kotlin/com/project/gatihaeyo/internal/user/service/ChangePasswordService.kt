package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.exception.AuthCodeMismatchException
import com.project.gatihaeyo.internal.auth.exception.UncertifiedEmailException
import com.project.gatihaeyo.internal.auth.port.QueryAuthCodePort
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.user.dto.ChangePasswordDto
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.port.CommandUserPort
import com.project.gatihaeyo.internal.user.port.QueryUserPort

@BusinessService
class ChangePasswordService(
    private val queryUserPort: QueryUserPort,
    private val commandUserPort: CommandUserPort,
    private val queryAuthCodePort: QueryAuthCodePort,
    private val securityPort: SecurityPort
) {

    fun execute(request: ChangePasswordDto) {
        val user = queryUserPort.queryUserByEmail(request.email)
            ?: throw UserNotFoundException.EXCEPTION

        val authCode = queryAuthCodePort.queryAuthCodeByEmail(request.email)
            ?: throw UncertifiedEmailException.EXCEPTION

        if (authCode.code != request.code) {
            throw AuthCodeMismatchException.EXCEPTION
        }

        commandUserPort.saveUser(
            user.copy(
                password = securityPort.encode(request.newPassword)
            )
        )
    }

}