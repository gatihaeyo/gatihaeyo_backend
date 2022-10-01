package com.project.gatihaeyo.local.token.application.service

import com.project.gatihaeyo.global.security.token.JwtGenerator
import com.project.gatihaeyo.local.token.dto.response.TokenResponse
import com.project.gatihaeyo.local.token.application.port.QueryRefreshTokenPort
import com.project.gatihaeyo.local.token.domain.exception.RefreshTokenNotFoundException
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