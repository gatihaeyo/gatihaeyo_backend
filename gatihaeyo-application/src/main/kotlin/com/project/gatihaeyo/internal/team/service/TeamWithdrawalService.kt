package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.exception.TeamMasterBreakawayException
import com.project.gatihaeyo.internal.team.exception.TeamMemberNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.port.CommandTeamMemberPort
import com.project.gatihaeyo.internal.team.port.CommandTeamPort
import com.project.gatihaeyo.internal.team.port.QueryTeamMemberPort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort
import java.util.UUID

@BusinessService
class TeamWithdrawalService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamMemberPort: QueryTeamMemberPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val securityPort: SecurityPort
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()

        val team = queryTeamPort.queryTeamById(teamId) ?: throw TeamNotFoundException.EXCEPTION

        when {
            currentUserId == team.master -> throw TeamMasterBreakawayException.EXCEPTION

            !queryTeamMemberPort.existsTeamMemberByUserIdAndTeamId(currentUserId, teamId)
                -> throw TeamMemberNotFoundException.EXCEPTION
        }

        commandTeamMemberPort.deleteTeamMemberByUserIdAndTeamId(currentUserId, teamId)

        commandTeamPort.saveTeam(
            team.copy(
                currentPersonnel = team.currentPersonnel.dec()
            )
        )
    }
}