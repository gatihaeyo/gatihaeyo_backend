package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.dto.DelegateTeamDto
import com.project.gatihaeyo.internal.team.exception.TeamMemberNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamPermissionException
import com.project.gatihaeyo.internal.team.port.CommandTeamPort
import com.project.gatihaeyo.internal.team.port.QueryTeamMemberPort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort

@BusinessService
class DelegateTeamService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamMemberPort: QueryTeamMemberPort,
    private val commandTeamPort: CommandTeamPort,
    private val securityPort: SecurityPort
) {

    fun execute(request: DelegateTeamDto) {
        val currentUserId = securityPort.getCurrentUserId()

        val team = queryTeamPort.queryTeamById(request.teamId) ?: throw TeamNotFoundException.EXCEPTION

        when {
            currentUserId != team.master -> throw TeamPermissionException.EXCEPTION

            !queryTeamMemberPort.existsTeamMemberByUserIdAndTeamId(request.userId, request.teamId)
                    -> throw TeamMemberNotFoundException.EXCEPTION
        }

        commandTeamPort.saveTeam(
            team.copy(
                master = request.userId
            )
        )
    }

}