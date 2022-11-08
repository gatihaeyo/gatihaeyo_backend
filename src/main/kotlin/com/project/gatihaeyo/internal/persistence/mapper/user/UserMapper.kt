package com.project.gatihaeyo.internal.persistence.mapper.user

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.domain.model.auth.User
import com.project.gatihaeyo.internal.persistence.model.user.UserEntity
import org.mapstruct.Mapper

@Mapper
abstract class UserMapper : GenericMapper<UserEntity, User> {
}