package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.exception.TeamFullPersonnelException
import com.project.gatihaeyo.internal.team.exception.TeamInvitationNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.model.TeamMember
import com.project.gatihaeyo.internal.team.port.CommandTeamInviteePort
import com.project.gatihaeyo.internal.team.port.CommandTeamMemberPort
import com.project.gatihaeyo.internal.team.port.CommandTeamPort
import com.project.gatihaeyo.internal.team.port.QueryTeamInviteePort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort
import java.util.UUID

@BusinessService
class ReceiveTeamInvitationService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamInviteePort: QueryTeamInviteePort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamInviteePort: CommandTeamInviteePort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val securityPort: SecurityPort
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()

        if (!queryTeamInviteePort.existsTeamInviteeByUserIdAndTeamId(currentUserId, teamId)) {
            throw TeamInvitationNotFoundException.EXCEPTION
        }

        val team = queryTeamPort.queryTeamById(teamId) ?: throw TeamNotFoundException.EXCEPTION

        if (team.personnel <= team.currentPersonnel) {
            throw TeamFullPersonnelException.EXCEPTION
        }

        commandTeamMemberPort.saveTeamMember(
            TeamMember(
                userId = currentUserId,
                teamId = teamId
            )
        )

        commandTeamPort.saveTeam(
            team.copy(
                currentPersonnel = team.currentPersonnel.inc()
            )
        )

        commandTeamInviteePort.deleteTeamInviteeByUserIdAndTeamId(
            userId = currentUserId,
            teamId = teamId
        )
    }
}