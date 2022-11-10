package com.project.gatihaeyo.internal.persistence.implement.team

import com.project.gatihaeyo.internal.application.port.team.CommandTeamDelayPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamDelayPort
import com.project.gatihaeyo.internal.domain.model.team.TeamDelay
import com.project.gatihaeyo.internal.persistence.mapper.team.TeamDelayMapper
import com.project.gatihaeyo.internal.persistence.repository.team.TeamDelayRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TeamDelayFacade(
    private val teamDelayMapper: TeamDelayMapper,
    private val teamDelayRepository: TeamDelayRepository
) : CommandTeamDelayPort, QueryTeamDelayPort {

    override fun saveTeamDelay(teamDelay: TeamDelay) = teamDelayMapper.toDomain(
        teamDelayRepository.save(
            teamDelayMapper.toEntity(teamDelay)
        )
    )!!

    override fun existsTeamDelayByTeamId(teamId: UUID): Boolean {
        return teamDelayRepository.existsById(teamId)
    }

}