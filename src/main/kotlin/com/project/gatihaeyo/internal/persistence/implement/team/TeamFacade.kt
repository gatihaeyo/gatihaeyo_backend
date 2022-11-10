package com.project.gatihaeyo.internal.persistence.implement.team

import com.project.gatihaeyo.internal.application.port.team.CommandTeamPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.model.team.Team
import com.project.gatihaeyo.internal.persistence.mapper.team.TeamMapper
import com.project.gatihaeyo.internal.persistence.repository.team.TeamJpaRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TeamFacade(
    private val teamJpaRepository: TeamJpaRepository,
    private val teamMapper: TeamMapper
) : CommandTeamPort, QueryTeamPort {

    override fun saveTeam(team: Team) = teamMapper.toDomain(
        teamJpaRepository.save(
            teamMapper.toEntity(team)
        )
    )!!

    override fun queryTeamById(id: UUID) = teamMapper.toDomain(
        teamJpaRepository.queryTeamEntityById(id)
    )

}