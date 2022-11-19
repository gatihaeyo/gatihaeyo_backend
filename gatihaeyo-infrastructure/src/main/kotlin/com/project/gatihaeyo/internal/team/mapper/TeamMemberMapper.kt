package com.project.gatihaeyo.internal.team.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.team.model.TeamMember
import com.project.gatihaeyo.internal.team.model.TeamMemberEntity
import com.project.gatihaeyo.internal.team.repository.TeamJpaRepository
import com.project.gatihaeyo.internal.user.repository.UserJpaRepository
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
    @Mapping(target = "key", expression = "java(new TeamUserEntityId(d.getUserId(), d.getTeamId()))")
    abstract override fun toEntity(d: TeamMember): TeamMemberEntity

}