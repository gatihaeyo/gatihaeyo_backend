package com.project.gatihaeyo.internal.team.implement

import com.project.gatihaeyo.internal.team.mapper.TeamInviteeMapper
import com.project.gatihaeyo.internal.team.model.TeamUserEntityId
import com.project.gatihaeyo.internal.team.repository.TeamInviteeJpaRepository
import com.project.gatihaeyo.internal.team.model.TeamInvitee
import com.project.gatihaeyo.internal.team.port.CommandTeamInviteePort
import com.project.gatihaeyo.internal.team.port.QueryTeamInviteePort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TeamInviteeFacade(
    private val teamInviteeMapper: TeamInviteeMapper,
    private val teamInviteeJpaRepository: TeamInviteeJpaRepository
) : CommandTeamInviteePort, QueryTeamInviteePort {

    override fun saveTeamInvitee(teamInvitee: TeamInvitee) = teamInviteeMapper.toDomain(
       teamInviteeJpaRepository.save(
           teamInviteeMapper.toEntity(
               teamInvitee
           )
       )
    )!!

    override fun deleteTeamInviteeByUserIdAndTeamId(userId: UUID, teamId: UUID) {
        teamInviteeJpaRepository.deleteById(
            TeamUserEntityId(
                userId = userId,
                teamId = teamId
            )
        )
    }

    override fun deleteTeamInviteeByTeamId(teamId: UUID) {
       teamInviteeJpaRepository.deleteTeamInviteeEntitiesByTeamId(teamId)
    }

    override fun existsTeamInviteeByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean {
        return teamInviteeJpaRepository.existsById(
            TeamUserEntityId(
                userId = userId,
                teamId = teamId
            )
        )
    }

    override fun queryTeamInviteesByUserId(userId: UUID): List<TeamInvitee> {
        return teamInviteeJpaRepository.queryTeamInviteeEntitiesByUserId(userId)
            .map {
                teamInviteeMapper.toDomain(it)!!
            }
    }

}