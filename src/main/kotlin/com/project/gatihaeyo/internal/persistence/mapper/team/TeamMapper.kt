package com.project.gatihaeyo.internal.persistence.mapper.team

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.domain.model.team.Team
import com.project.gatihaeyo.internal.persistence.model.team.TeamEntity
import com.project.gatihaeyo.internal.persistence.repository.user.UserJpaRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class TeamMapper : GenericMapper<TeamEntity, Team> {

    @Autowired
    protected lateinit var userJpaRepository: UserJpaRepository

    @Mapping(target = "master", expression = "java(e.getMaster().getId())")
    abstract override fun toDomain(e: TeamEntity?): Team?

    @Mapping(target = "master", expression = "java(userJpaRepository.queryUserEntityById(d.getMaster()))")
    abstract override fun toEntity(d: Team): TeamEntity

}