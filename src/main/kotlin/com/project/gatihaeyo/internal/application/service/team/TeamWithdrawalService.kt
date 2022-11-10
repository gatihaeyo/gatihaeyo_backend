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
import java.util.UUID

@BusinessService
class TeamWithdrawalService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamMemberPort: QueryTeamMemberPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val securityService: SecurityService
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityService.getCurrentUserId()

        val team = queryTeamPort.queryTeamById(teamId) ?: throw TeamNotFoundException.EXCEPTION

        if (currentUserId == team.master) {
            throw TeamMasterBreakawayException.EXCEPTION
        }

        if (!queryTeamMemberPort.existsTeamMemberByUserIdAndTeamId(currentUserId, teamId)) {
            throw TeamMemberNotFoundException.EXCEPTION
        }

        commandTeamMemberPort.deleteTeamMemberByUserIdAndTeamId(currentUserId, teamId)

        commandTeamPort.saveTeam(
            team.copy(
                currentPersonnel = team.currentPersonnel.dec()
            )
        )
    }
}