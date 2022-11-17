package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.exception.DifferentPasswordException
import com.project.gatihaeyo.internal.auth.port.GenerateJwtPort
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.auth.dto.response.TokenResponse
import com.project.gatihaeyo.internal.user.dto.LoginDto
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.port.QueryUserPort

@BusinessService
class LoginService(
    private val queryUserPort: QueryUserPort,
    private val securityService: SecurityPort,
    private val jwtGenerator: GenerateJwtPort
) {

    fun execute(request: LoginDto): TokenResponse {
        val user = queryUserPort.queryUserByNickname(request.nickname) ?: throw UserNotFoundException.EXCEPTION

        if (!securityService.compare(request.password, user.password)) {
            throw DifferentPasswordException.EXCEPTION
        }

        return jwtGenerator.issuanceToken(
            userId = user.id,
            authority = user.authority
        )
    }

}