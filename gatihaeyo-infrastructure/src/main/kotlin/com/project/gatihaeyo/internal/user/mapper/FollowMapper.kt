package com.project.gatihaeyo.internal.user.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.user.model.Follow
import com.project.gatihaeyo.internal.user.model.FollowEntity
import com.project.gatihaeyo.internal.user.repository.UserJpaRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class FollowMapper : GenericMapper<FollowEntity, Follow> {

    @Autowired
    protected lateinit var userJpaRepository: UserJpaRepository

    @Mapping(target = "userId", expression = "java(e.getKey().getUserId())")
    @Mapping(target = "followId", expression = "java(e.getKey().getFollowId())")
    abstract override fun toDomain(e: FollowEntity?): Follow?

    @Mapping(target = "user", expression = "java(userJpaRepository.queryUserEntityById(d.getUserId()))")
    @Mapping(target = "follow", expression = "java(userJpaRepository.queryUserEntityById(d.getFollowId()))")
    abstract override fun toEntity(d: Follow): FollowEntity
}