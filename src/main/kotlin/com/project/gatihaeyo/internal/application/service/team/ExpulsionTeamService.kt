package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.CommandTeamMemberPort
import com.project.gatihaeyo.internal.application.port.team.CommandTeamPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamMemberPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.exception.team.TeamMasterBreakawayException
import com.project.gatihaeyo.internal.domain.exception.team.TeamMemberNotFoundException
import com.project.gatihaeyo.internal.domain.exception.team.TeamNotFoundException
import com.project.gatihaeyo.internal.domain.exception.team.TeamPermissionException
import com.project.gatihaeyo.internal.dto.request.team.ExpulsionTeamRequest

@BusinessService
class ExpulsionTeamService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamMemberPort: QueryTeamMemberPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val securityService: SecurityService
) {

    fun execute(request: ExpulsionTeamRequest) {
        val currentUserId = securityService.getCurrentUserId()

        val team = queryTeamPort.queryTeamById(request.teamId) ?: throw TeamNotFoundException.EXCEPTION

        when {
            currentUserId == request.userId -> throw TeamMasterBreakawayException.EXCEPTION

            currentUserId != team.master -> throw TeamPermissionException.EXCEPTION

            !queryTeamMemberPort.existsTeamMemberByUserIdAndTeamId(request.userId, request.teamId)
                    -> throw TeamMemberNotFoundException.EXCEPTION
        }

        commandTeamMemberPort.deleteTeamMemberByUserIdAndTeamId(request.userId, request.teamId)

        commandTeamPort.saveTeam(
            team.copy(
                currentPersonnel = team.currentPersonnel.dec()
            )
        )
    }
}