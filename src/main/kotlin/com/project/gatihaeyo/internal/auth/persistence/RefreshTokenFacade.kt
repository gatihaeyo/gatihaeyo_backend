package com.project.gatihaeyo.internal.auth.persistence

import com.project.gatihaeyo.internal.auth.application.port.CommandRefreshTokenPort
import com.project.gatihaeyo.internal.auth.application.port.QueryRefreshTokenPort
import com.project.gatihaeyo.internal.auth.domain.model.RefreshToken
import com.project.gatihaeyo.internal.auth.persistence.mapper.RefreshTokenMapper
import com.project.gatihaeyo.internal.auth.persistence.repository.RefreshTokenRepository
import org.springframework.stereotype.Component

@Component
class RefreshTokenFacade(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper
): QueryRefreshTokenPort, CommandRefreshTokenPort {

    override fun queryRefreshTokenByToken(token: String): RefreshToken? {
        return refreshTokenMapper.toDomain(
            refreshTokenRepository.queryRefreshTokenEntityByToken(token)
        )
    }

    override fun save(token: RefreshToken) = refreshTokenMapper.toDomain(
        refreshTokenRepository.save(
            refreshTokenMapper.toEntity(token)
        )
    )!!

}