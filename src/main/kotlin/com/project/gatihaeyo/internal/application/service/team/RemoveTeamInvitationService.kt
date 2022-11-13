package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.CommandTeamInviteePort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamInviteePort
import com.project.gatihaeyo.internal.domain.exception.team.TeamInvitationNotFoundException
import java.util.UUID

@BusinessService
class RemoveTeamInvitationService(
    private val queryTeamInviteePort: QueryTeamInviteePort,
    private val commandTeamInviteePort: CommandTeamInviteePort,
    private val securityService: SecurityService
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityService.getCurrentUserId()

        if (!queryTeamInviteePort.existsTeamInviteeByUserIdAndTeamId(currentUserId, teamId)) {
            throw TeamInvitationNotFoundException.EXCEPTION
        }

        commandTeamInviteePort.deleteTeamInviteeByUserIdAndTeamId(currentUserId, teamId)
    }
}