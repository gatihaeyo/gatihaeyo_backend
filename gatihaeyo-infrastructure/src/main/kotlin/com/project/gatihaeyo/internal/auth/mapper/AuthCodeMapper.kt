package com.project.gatihaeyo.internal.auth.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.auth.model.AuthCode
import com.project.gatihaeyo.internal.auth.model.AuthCodeEntity
import org.mapstruct.Mapper

@Mapper
abstract class AuthCodeMapper : GenericMapper<AuthCodeEntity, AuthCode> {

}