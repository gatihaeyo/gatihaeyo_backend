package com.project.gatihaeyo.internal.persistence.mapper.team

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.domain.model.team.TeamApplicant
import com.project.gatihaeyo.internal.persistence.model.team.TeamApplicantEntity
import com.project.gatihaeyo.internal.persistence.repository.team.TeamJpaRepository
import com.project.gatihaeyo.internal.persistence.repository.user.UserJpaRepository
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

    @Mapping(target = "user", expression = "java(userJpaRepository.queryUserById(d.getUserId()))")
    @Mapping(target = "team", expression = "java(teamJpaRepository.queryTeamById(d.getTeamId()))")
    abstract override fun toEntity(d: TeamApplicant): TeamApplicantEntity

}