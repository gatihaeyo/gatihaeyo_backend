package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.dto.ExpulsionTeamDto
import com.project.gatihaeyo.internal.team.exception.TeamMasterBreakawayException
import com.project.gatihaeyo.internal.team.exception.TeamMemberNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamPermissionException
import com.project.gatihaeyo.internal.team.port.CommandTeamMemberPort
import com.project.gatihaeyo.internal.team.port.CommandTeamPort
import com.project.gatihaeyo.internal.team.port.QueryTeamMemberPort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort

@BusinessService
class ExpulsionTeamService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamMemberPort: QueryTeamMemberPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val securityPort: SecurityPort
) {

    fun execute(request: ExpulsionTeamDto) {
        val currentUserId = securityPort.getCurrentUserId()

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