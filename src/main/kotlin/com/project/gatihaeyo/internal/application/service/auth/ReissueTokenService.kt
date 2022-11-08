package com.project.gatihaeyo.internal.application.service.auth

import com.project.gatihaeyo.global.security.token.JwtGenerator
import com.project.gatihaeyo.internal.dto.response.auth.TokenResponse
import com.project.gatihaeyo.internal.application.port.auth.QueryRefreshTokenPort
import com.project.gatihaeyo.internal.domain.exception.auth.RefreshTokenNotFoundException
import org.springframework.stereotype.Service

@Service
class ReissueTokenService(
    private val queryRefreshTokenPort: QueryRefreshTokenPort,
    private val jwtGenerator: JwtGenerator
) {

    fun execute(request: String): TokenResponse {
        val token = queryRefreshTokenPort.queryRefreshTokenByToken(request) ?: throw RefreshTokenNotFoundException.EXCEPTION

        return jwtGenerator.issuanceToken(
            token.userId,
            token.authority
        )
    }

}