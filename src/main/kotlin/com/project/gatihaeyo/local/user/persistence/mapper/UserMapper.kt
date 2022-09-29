package com.project.gatihaeyo.local.user.persistence.mapper

import com.project.gatihaeyo.global.basemodel.GenericMapper
import com.project.gatihaeyo.local.user.domain.model.User
import com.project.gatihaeyo.local.user.persistence.model.UserEntity
import org.mapstruct.Mapper

@Mapper
abstract class UserMapper : GenericMapper<UserEntity, User> {
}