package com.project.gatihaeyo.internal.message.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.message.model.Message
import com.project.gatihaeyo.internal.message.model.MessageEntity
import com.project.gatihaeyo.internal.team.repository.TeamJpaRepository
import com.project.gatihaeyo.internal.user.repository.UserJpaRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class MessageMapper : GenericMapper<MessageEntity, Message> {

    @Autowired
    protected lateinit var teamJpaRepository: TeamJpaRepository

    @Autowired
    protected lateinit var userJpaRepository: UserJpaRepository

    @Mapping(target = "room", expression = "java(teamJpaRepository.queryTeamEntityById(d.getRoomId()))")
    @Mapping(target = "user", expression = "java(userJpaRepository.queryUserEntityById(d.getUserId()))")
    abstract override fun toEntity(d: Message): MessageEntity

    @Mapping(target = "roomId", expression = "java(e.getRoom().getId())")
    @Mapping(target = "userId", expression = "java(e.getUser().getId())")
    abstract override fun toDomain(e: MessageEntity?): Message?

}