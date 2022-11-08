package com.project.gatihaeyo.internal.persistence.mapper.auth

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.domain.model.user.AuthCode
import com.project.gatihaeyo.internal.persistence.model.auth.AuthCodeEntity
import org.mapstruct.Mapper

@Mapper
abstract class AuthCodeMapper : GenericMapper<AuthCodeEntity, AuthCode> {

}