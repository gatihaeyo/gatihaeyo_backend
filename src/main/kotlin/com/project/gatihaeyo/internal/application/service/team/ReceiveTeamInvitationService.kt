package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.CommandTeamInviteePort
import com.project.gatihaeyo.internal.application.port.team.CommandTeamMemberPort
import com.project.gatihaeyo.internal.application.port.team.CommandTeamPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamInviteePort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.exception.team.TeamFullPersonnelException
import com.project.gatihaeyo.internal.domain.exception.team.TeamInvitationNotFoundException
import com.project.gatihaeyo.internal.domain.exception.team.TeamNotFoundException
import com.project.gatihaeyo.internal.domain.model.team.TeamMember
import java.util.UUID

@BusinessService
class ReceiveTeamInvitationService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamInviteePort: QueryTeamInviteePort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamInviteePort: CommandTeamInviteePort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val securityService: SecurityService
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityService.getCurrentUserId()

        if (!queryTeamInviteePort.existsTeamInviteeByUserIdAndTeamId(currentUserId, teamId)) {
            throw TeamInvitationNotFoundException.EXCEPTION
        }

        val team = queryTeamPort.queryTeamById(teamId) ?: throw TeamNotFoundException.EXCEPTION

        if (team.personnel < team.currentPersonnel.inc()) {
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