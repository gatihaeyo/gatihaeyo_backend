package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.CommandTeamInviteePort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamInviteePort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.exception.team.AlreadyInviteTeamException
import com.project.gatihaeyo.internal.domain.exception.team.TeamNotFoundException
import com.project.gatihaeyo.internal.domain.exception.team.TeamPermissionException
import com.project.gatihaeyo.internal.domain.model.team.TeamInvitee
import com.project.gatihaeyo.internal.dto.request.team.InviteTeamRequest

@BusinessService
class InviteTeamService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamInviteePort: QueryTeamInviteePort,
    private val commandTeamInviteePort: CommandTeamInviteePort,
    private val securityService: SecurityService
) {

    fun execute(request: InviteTeamRequest) {
        val currentUserId = securityService.getCurrentUserId()

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