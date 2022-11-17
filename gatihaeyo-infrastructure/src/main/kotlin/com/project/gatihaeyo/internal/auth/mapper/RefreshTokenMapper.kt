package com.project.gatihaeyo.internal.auth.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.auth.model.RefreshToken
import com.project.gatihaeyo.internal.auth.model.RefreshTokenEntity
import org.mapstruct.Mapper

@Mapper
abstract class RefreshTokenMapper : GenericMapper<RefreshTokenEntity, RefreshToken> {
}