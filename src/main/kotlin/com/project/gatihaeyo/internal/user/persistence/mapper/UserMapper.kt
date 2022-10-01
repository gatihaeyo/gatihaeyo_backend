package com.project.gatihaeyo.internal.user.persistence.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.user.domain.model.User
import com.project.gatihaeyo.internal.user.persistence.model.UserEntity
import org.mapstruct.Mapper

@Mapper
abstract class UserMapper : GenericMapper<UserEntity, User> {
}