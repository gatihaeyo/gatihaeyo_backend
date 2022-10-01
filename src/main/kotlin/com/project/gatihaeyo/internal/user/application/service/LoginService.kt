package com.project.gatihaeyo.internal.user.application.service

import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.global.security.token.JwtGenerator
import com.project.gatihaeyo.internal.user.dto.request.LoginRequest
import com.project.gatihaeyo.internal.auth.dto.response.TokenResponse
import com.project.gatihaeyo.internal.user.application.port.QueryUserPort
import com.project.gatihaeyo.internal.user.domain.exception.DifferentPasswordException
import com.project.gatihaeyo.internal.user.domain.exception.UserNotFoundException
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val queryUserPort: QueryUserPort,
    private val securityService: SecurityService,
    private val jwtGenerator: JwtGenerator
) {

    fun execute(request: LoginRequest): TokenResponse {
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