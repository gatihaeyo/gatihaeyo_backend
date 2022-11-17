package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamPermissionException
import com.project.gatihaeyo.internal.team.port.CommandTeamApplicantPort
import com.project.gatihaeyo.internal.team.port.CommandTeamInviteePort
import com.project.gatihaeyo.internal.team.port.CommandTeamMemberPort
import com.project.gatihaeyo.internal.team.port.CommandTeamPort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort
import java.util.UUID

@BusinessService
class TeamDissipateService(
    private val queryTeamPort: QueryTeamPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamApplicantPort: CommandTeamApplicantPort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val commandTeamInviteePort: CommandTeamInviteePort,
    private val securityPort: SecurityPort
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()

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