package com.project.gatihaeyo.internal.user.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.user.model.UserEntity
import com.project.gatihaeyo.internal.user.model.User
import org.mapstruct.Mapper

@Mapper
abstract class UserMapper : GenericMapper<UserEntity, User> {
}