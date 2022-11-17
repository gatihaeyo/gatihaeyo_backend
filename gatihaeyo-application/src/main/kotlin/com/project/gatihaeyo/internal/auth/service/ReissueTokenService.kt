package com.project.gatihaeyo.internal.auth.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.exception.RefreshTokenNotFoundException
import com.project.gatihaeyo.internal.auth.port.GenerateJwtPort
import com.project.gatihaeyo.internal.auth.port.QueryRefreshTokenPort
import com.project.gatihaeyo.internal.auth.dto.response.TokenResponse

@BusinessService
class ReissueTokenService(
    private val queryRefreshTokenPort: QueryRefreshTokenPort,
    private val generateJwtPort: GenerateJwtPort
) {

    fun execute(request: String): TokenResponse {
        val token = queryRefreshTokenPort.queryRefreshTokenByToken(request) ?: throw RefreshTokenNotFoundException.EXCEPTION

        return generateJwtPort.issuanceToken(
            token.userId,
            token.authority
        )
    }

}