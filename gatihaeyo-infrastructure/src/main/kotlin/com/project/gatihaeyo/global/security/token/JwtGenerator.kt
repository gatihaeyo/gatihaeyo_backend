package com.project.gatihaeyo.global.security.token

import com.project.gatihaeyo.global.security.SecurityProperties
import com.project.gatihaeyo.internal.auth.Authority
import com.project.gatihaeyo.internal.auth.model.RefreshToken
import com.project.gatihaeyo.internal.auth.port.CommandRefreshTokenPort
import com.project.gatihaeyo.internal.auth.port.GenerateJwtPort
import com.project.gatihaeyo.internal.auth.dto.response.TokenResponse
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.Date
import java.util.UUID

@Component
class JwtGenerator(
    private val commandRefreshTokenPort: CommandRefreshTokenPort,
    private val securityProperties: SecurityProperties
) : GenerateJwtPort {

    private fun accessToken(userId: UUID, authority: Authority): String {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperties.encodingSecretKey)
            .setHeaderParam(Header.JWT_TYPE, JwtComponent.ACCESS)
            .setId(userId.toString())
            .claim(JwtComponent.AUTHORITY, authority)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExpiredTime))
            .compact()
    }

    private fun refreshToken(userId: UUID, authority: Authority): String {
        val token = Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperties.encodingSecretKey)
            .setHeaderParam(Header.JWT_TYPE, JwtComponent.REFRESH)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExpiredTime))
            .compact()

        commandRefreshTokenPort.save(
            RefreshToken(
                token = token,
                authority = authority,
                userId = userId,
                expirationTime = securityProperties.refreshExpiredTime / 1000
            )
        )

        return token
    }

    override fun issuanceToken(userId: UUID, authority: Authority) = TokenResponse(
        accessToken = accessToken(userId, authority),
        refreshToken = refreshToken(userId, authority),
        accessExpiredTime = Date(System.currentTimeMillis() + securityProperties.accessExpiredTime)
    )
}