package com.project.gatihaeyo.internal.persistence.mapper.user

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.domain.model.user.Friend
import com.project.gatihaeyo.internal.persistence.model.user.FriendEntity
import com.project.gatihaeyo.internal.persistence.repository.user.UserJpaRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class FriendMapper : GenericMapper<FriendEntity, Friend> {

    @Autowired
    protected lateinit var userJpaRepository: UserJpaRepository

    @Mapping(target = "userId", expression = "java(e.getKey().getUserId())")
    @Mapping(target = "friendId", expression = "java(e.getKey().getFriendId())")
    abstract override fun toDomain(e: FriendEntity?): Friend?

    @Mapping(target = "user", expression = "java(userJpaRepository.queryUserEntityById(d.getUserId()))")
    @Mapping(target = "friend", expression = "java(userJpaRepository.queryUserEntityById(d.getFriendId()))")
    abstract override fun toEntity(d: Friend): FriendEntity
}