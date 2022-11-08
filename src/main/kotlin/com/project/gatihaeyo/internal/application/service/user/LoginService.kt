package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.global.security.token.JwtGenerator
import com.project.gatihaeyo.internal.dto.request.user.LoginRequest
import com.project.gatihaeyo.internal.dto.response.auth.TokenResponse
import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.exception.auth.DifferentPasswordException
import com.project.gatihaeyo.internal.domain.exception.user.UserNotFoundException
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