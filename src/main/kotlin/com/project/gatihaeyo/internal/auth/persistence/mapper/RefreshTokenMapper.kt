package com.project.gatihaeyo.internal.auth.persistence.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.auth.domain.model.RefreshToken
import com.project.gatihaeyo.internal.auth.persistence.model.RefreshTokenEntity
import org.mapstruct.Mapper

@Mapper
abstract class RefreshTokenMapper : GenericMapper<RefreshTokenEntity, RefreshToken> {
}