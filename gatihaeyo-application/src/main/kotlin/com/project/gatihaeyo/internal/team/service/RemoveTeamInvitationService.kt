package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.exception.TeamInvitationNotFoundException
import com.project.gatihaeyo.internal.team.port.CommandTeamInviteePort
import com.project.gatihaeyo.internal.team.port.QueryTeamInviteePort
import java.util.UUID

@BusinessService
class RemoveTeamInvitationService(
    private val queryTeamInviteePort: QueryTeamInviteePort,
    private val commandTeamInviteePort: CommandTeamInviteePort,
    private val securityPort: SecurityPort
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()

        if (!queryTeamInviteePort.existsTeamInviteeByUserIdAndTeamId(currentUserId, teamId)) {
            throw TeamInvitationNotFoundException.EXCEPTION
        }

        commandTeamInviteePort.deleteTeamInviteeByUserIdAndTeamId(currentUserId, teamId)
    }
}