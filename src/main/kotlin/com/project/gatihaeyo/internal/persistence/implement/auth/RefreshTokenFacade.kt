package com.project.gatihaeyo.internal.persistence.implement.auth

import com.project.gatihaeyo.internal.application.port.auth.CommandRefreshTokenPort
import com.project.gatihaeyo.internal.application.port.auth.QueryRefreshTokenPort
import com.project.gatihaeyo.internal.domain.model.user.RefreshToken
import com.project.gatihaeyo.internal.persistence.mapper.auth.RefreshTokenMapper
import com.project.gatihaeyo.internal.persistence.repository.auth.RefreshTokenRepository
import org.springframework.stereotype.Component

@Component
class RefreshTokenFacade(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper
): QueryRefreshTokenPort, CommandRefreshTokenPort {

    override fun queryRefreshTokenByToken(token: String): RefreshToken? {
        return refreshTokenMapper.toDomain(
            refreshTokenRepository.findById(token).orElse(null)
        )
    }

    override fun save(token: RefreshToken) = refreshTokenMapper.toDomain(
        refreshTokenRepository.save(
            refreshTokenMapper.toEntity(token)
        )
    )!!

}