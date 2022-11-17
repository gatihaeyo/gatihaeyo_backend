package com.project.gatihaeyo.internal.team.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.team.model.TeamApplicant
import com.project.gatihaeyo.internal.team.model.TeamApplicantEntity
import com.project.gatihaeyo.internal.team.repository.TeamJpaRepository
import com.project.gatihaeyo.internal.user.repository.UserJpaRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class TeamApplicantMapper : GenericMapper<TeamApplicantEntity, TeamApplicant> {

    @Autowired
    protected lateinit var teamJpaRepository: TeamJpaRepository

    @Autowired
    protected lateinit var userJpaRepository: UserJpaRepository

    @Mapping(target = "userId", expression = "java(e.getKey().getUserId())")
    @Mapping(target = "teamId", expression = "java(e.getKey().getTeamId())")
    abstract override fun toDomain(e: TeamApplicantEntity?): TeamApplicant?

    @Mapping(target = "user", expression = "java(userJpaRepository.queryUserEntityById(d.getUserId()))")
    @Mapping(target = "team", expression = "java(teamJpaRepository.queryTeamEntityById(d.getTeamId()))")
    abstract override fun toEntity(d: TeamApplicant): TeamApplicantEntity

}