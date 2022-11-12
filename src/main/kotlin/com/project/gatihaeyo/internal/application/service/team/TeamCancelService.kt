package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.CommandTeamApplicantPort
import com.project.gatihaeyo.internal.application.port.team.CommandTeamInviteePort
import com.project.gatihaeyo.internal.application.port.team.CommandTeamMemberPort
import com.project.gatihaeyo.internal.application.port.team.CommandTeamPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.exception.team.TeamNotFoundException
import com.project.gatihaeyo.internal.domain.exception.team.TeamPermissionException
import java.util.UUID

@BusinessService
class TeamCancelService(
    private val queryTeamPort: QueryTeamPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamApplicantPort: CommandTeamApplicantPort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val commandTeamInviteePort: CommandTeamInviteePort,
    private val securityService: SecurityService
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityService.getCurrentUserId()

        val team = queryTeamPort.queryTeamById(teamId) ?: throw TeamNotFoundException.EXCEPTION

        if (currentUserId != team.master) {
            throw TeamPermissionException.EXCEPTION
        }

        commandTeamInviteePort.deleteTeamInviteeByTeamId(teamId)

        commandTeamApplicantPort.deleteTeamApplicantByTeamId(teamId)

        commandTeamMemberPort.deleteTeamMemberByTeamId(teamId)

        commandTeamPort.deleteTeamById(teamId)
    }

}