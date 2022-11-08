package com.project.gatihaeyo.internal.persistence.mapper.auth

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.domain.model.user.RefreshToken
import com.project.gatihaeyo.internal.persistence.model.auth.RefreshTokenEntity
import org.mapstruct.Mapper

@Mapper
abstract class RefreshTokenMapper : GenericMapper<RefreshTokenEntity, RefreshToken> {
}