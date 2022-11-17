package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.dto.InviteTeamDto
import com.project.gatihaeyo.internal.team.exception.AlreadyInviteTeamException
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamPermissionException
import com.project.gatihaeyo.internal.team.model.TeamInvitee
import com.project.gatihaeyo.internal.team.port.CommandTeamInviteePort
import com.project.gatihaeyo.internal.team.port.QueryTeamInviteePort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort

@BusinessService
class InviteTeamService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamInviteePort: QueryTeamInviteePort,
    private val commandTeamInviteePort: CommandTeamInviteePort,
    private val securityPort: SecurityPort
) {

    fun execute(request: InviteTeamDto) {
        val currentUserId = securityPort.getCurrentUserId()

        val team = queryTeamPort.queryTeamById(request.teamId) ?: throw TeamNotFoundException.EXCEPTION

        if (team.master != currentUserId) {
            throw TeamPermissionException.EXCEPTION
        }

        if (queryTeamInviteePort.existsTeamInviteeByUserIdAndTeamId(request.userId, request.teamId)) {
            throw AlreadyInviteTeamException.EXCEPTION
        }

        commandTeamInviteePort.saveTeamInvitee(
            TeamInvitee(
                userId = request.userId,
                teamId = request.teamId
            )
        )
    }

}