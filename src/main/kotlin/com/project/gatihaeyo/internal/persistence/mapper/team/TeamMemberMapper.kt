package com.project.gatihaeyo.internal.persistence.mapper.team

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.domain.model.team.TeamMember
import com.project.gatihaeyo.internal.persistence.model.team.TeamMemberEntity
import com.project.gatihaeyo.internal.persistence.repository.team.TeamJpaRepository
import com.project.gatihaeyo.internal.persistence.repository.user.UserJpaRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class TeamMemberMapper : GenericMapper<TeamMemberEntity, TeamMember> {

    @Autowired
    protected lateinit var userJpaRepository: UserJpaRepository

    @Autowired
    protected lateinit var teamJpaRepository: TeamJpaRepository

    @Mapping(target = "userId", expression = "java(e.getKey().getUserId())")
    @Mapping(target = "teamId", expression = "java(e.getKey().getTeamId())")
    abstract override fun toDomain(e: TeamMemberEntity?): TeamMember?

    @Mapping(target = "user", expression = "java(userJpaRepository.queryUserEntityById(d.getUserId()))")
    @Mapping(target = "team", expression = "java(teamJpaRepository.queryTeamEntityById(d.getTeamId()))")
    abstract override fun toEntity(d: TeamMember): TeamMemberEntity

}