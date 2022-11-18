package com.project.gatihaeyo.internal.auth.implement

import com.project.gatihaeyo.internal.auth.model.RefreshToken
import com.project.gatihaeyo.internal.auth.port.CommandRefreshTokenPort
import com.project.gatihaeyo.internal.auth.port.QueryRefreshTokenPort
import com.project.gatihaeyo.internal.auth.mapper.RefreshTokenMapper
import com.project.gatihaeyo.internal.auth.repository.RefreshTokenRepository
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