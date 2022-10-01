package com.project.gatihaeyo.internal.auth.application.service

import com.project.gatihaeyo.global.security.token.JwtGenerator
import com.project.gatihaeyo.internal.auth.dto.response.TokenResponse
import com.project.gatihaeyo.internal.auth.application.port.QueryRefreshTokenPort
import com.project.gatihaeyo.internal.auth.domain.exception.RefreshTokenNotFoundException
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