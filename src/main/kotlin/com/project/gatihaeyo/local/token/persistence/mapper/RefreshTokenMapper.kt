package com.project.gatihaeyo.local.token.persistence.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.local.token.domain.model.RefreshToken
import com.project.gatihaeyo.local.token.persistence.model.RefreshTokenEntity
import org.mapstruct.Mapper

@Mapper
abstract class RefreshTokenMapper : GenericMapper<RefreshTokenEntity, RefreshToken> {
}