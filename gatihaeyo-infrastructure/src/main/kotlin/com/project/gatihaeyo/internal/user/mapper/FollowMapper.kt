package com.project.gatihaeyo.internal.user.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.user.model.FollowEntity
import com.project.gatihaeyo.internal.user.repository.UserJpaRepository
import com.project.gatihaeyo.internal.user.model.Friend
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class FollowMapper : GenericMapper<FollowEntity, Friend> {

    @Autowired
    protected lateinit var userJpaRepository: UserJpaRepository

    @Mapping(target = "userId", expression = "java(e.getKey().getUserId())")
    @Mapping(target = "friendId", expression = "java(e.getKey().getFriendId())")
    abstract override fun toDomain(e: FollowEntity?): Friend?

    @Mapping(target = "user", expression = "java(userJpaRepository.queryUserEntityById(d.getUserId()))")
    @Mapping(target = "friend", expression = "java(userJpaRepository.queryUserEntityById(d.getFriendId()))")
    abstract override fun toEntity(d: Friend): FollowEntity
}