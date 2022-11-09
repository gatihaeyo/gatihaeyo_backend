package com.project.gatihaeyo.internal.application.service.auth

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.token.JwtGenerator
import com.project.gatihaeyo.internal.application.port.auth.QueryRefreshTokenPort
import com.project.gatihaeyo.internal.domain.exception.auth.RefreshTokenNotFoundException
import com.project.gatihaeyo.internal.dto.response.auth.TokenResponse

@BusinessService
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