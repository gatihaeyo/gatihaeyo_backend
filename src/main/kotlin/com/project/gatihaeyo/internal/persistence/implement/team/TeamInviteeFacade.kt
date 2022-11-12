package com.project.gatihaeyo.internal.persistence.implement.team

import com.project.gatihaeyo.internal.application.port.team.CommandTeamInviteePort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamInviteePort
import com.project.gatihaeyo.internal.domain.model.team.TeamInvitee
import com.project.gatihaeyo.internal.persistence.mapper.team.TeamInviteeMapper
import com.project.gatihaeyo.internal.persistence.model.team.TeamUserEntityId
import com.project.gatihaeyo.internal.persistence.repository.team.TeamInviteeJpaRepository
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
        teamInviteeJpaRepository.deleteTeamInviteeEntityByKey(
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

}