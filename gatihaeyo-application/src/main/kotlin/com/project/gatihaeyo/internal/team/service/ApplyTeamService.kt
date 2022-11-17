package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.exception.AlreadyApplyTeamException
import com.project.gatihaeyo.internal.team.exception.AlreadyJoinTeamException
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.model.TeamApplicant
import com.project.gatihaeyo.internal.team.port.CommandTeamApplicantPort
import com.project.gatihaeyo.internal.team.port.CommandTeamPort
import com.project.gatihaeyo.internal.team.port.QueryTeamApplicantPort
import com.project.gatihaeyo.internal.team.port.QueryTeamMemberPort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort
import java.util.UUID

@BusinessService
class ApplyTeamService(
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamApplicantPort: CommandTeamApplicantPort,
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamMemberPort: QueryTeamMemberPort,
    private val queryTeamApplicantPort: QueryTeamApplicantPort,
    private val securityPort: SecurityPort
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()

        val team = queryTeamPort.queryTeamById(teamId) ?: throw TeamNotFoundException.EXCEPTION

        if (queryTeamApplicantPort.existsTeamApplicantByUserIdAndTeamId(currentUserId, teamId)) {
            throw AlreadyApplyTeamException.EXCEPTION
        }

        if (queryTeamMemberPort.existsTeamMemberByUserIdAndTeamId(currentUserId, teamId)) {
            throw AlreadyJoinTeamException.EXCEPTION
        }

        commandTeamApplicantPort.saveTeamApplicant(
            TeamApplicant(
                userId = currentUserId,
                teamId = teamId
            )
        )

        commandTeamPort.saveTeam(
            team.copy(
                applicantPersonnel = team.applicantPersonnel.inc()
            )
        )
    }
}