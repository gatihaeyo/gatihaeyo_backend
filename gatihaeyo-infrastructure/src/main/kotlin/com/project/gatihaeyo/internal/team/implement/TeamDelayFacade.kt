package com.project.gatihaeyo.internal.team.implement

import com.project.gatihaeyo.internal.team.mapper.TeamDelayMapper
import com.project.gatihaeyo.internal.team.model.TeamDelay
import com.project.gatihaeyo.internal.team.port.CommandTeamDelayPort
import com.project.gatihaeyo.internal.team.port.QueryTeamDelayPort
import com.project.gatihaeyo.internal.team.repository.TeamDelayRepository
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