package com.project.gatihaeyo.internal.notice.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.notice.model.Notice
import com.project.gatihaeyo.internal.notice.model.NoticeEntity
import com.project.gatihaeyo.internal.user.repository.UserJpaRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class NoticeMapper : GenericMapper<NoticeEntity, Notice> {

    @Autowired
    protected lateinit var userJpaRepository: UserJpaRepository

    @Mapping(target = "userId", expression = "java(e.getUser().getId())")
    abstract override fun toDomain(e: NoticeEntity?): Notice?

    @Mapping(target = "user", expression = "java(userJpaRepository.queryUserEntityById(d.getUserId()))")
    abstract override fun toEntity(d: Notice): NoticeEntity
}