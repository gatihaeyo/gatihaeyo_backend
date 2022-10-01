package com.project.gatihaeyo.local.token.persistence

import com.project.gatihaeyo.local.token.application.port.CommandRefreshTokenPort
import com.project.gatihaeyo.local.token.application.port.QueryRefreshTokenPort
import com.project.gatihaeyo.local.token.domain.model.RefreshToken
import com.project.gatihaeyo.local.token.persistence.mapper.RefreshTokenMapper
import com.project.gatihaeyo.local.token.persistence.repository.RefreshTokenRepository
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