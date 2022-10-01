package com.project.gatihaeyo.internal.auth.persistence.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.auth.domain.model.AuthCode
import com.project.gatihaeyo.internal.auth.persistence.model.AuthCodeEntity
import org.mapstruct.Mapper

@Mapper
abstract class AuthCodeMapper : GenericMapper<AuthCodeEntity, AuthCode> {

}