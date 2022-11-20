package com.project.gatihaeyo.internal.report.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.report.model.Report
import com.project.gatihaeyo.internal.report.model.ReportEntity
import com.project.gatihaeyo.internal.user.repository.UserJpaRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class ReportMapper : GenericMapper<ReportEntity, Report> {

    @Autowired
    protected lateinit var userJpaRepository: UserJpaRepository

    @Mapping(target = "userId", expression = "java(e.getUser().getId())")
    @Mapping(target = "reportUserId", expression = "java(e.getSuspect().getId())")
    abstract override fun toDomain(e: ReportEntity?): Report?

    @Mapping(target = "user", expression = "java(userJpaRepository.queryUserEntityById(d.getUserId()))")
    @Mapping(target = "suspect", expression = "java(userJpaRepository.queryUserEntityById(d.getReportUserId()))")
    abstract override fun toEntity(d: Report): ReportEntity
}