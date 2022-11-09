package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.CommandTeamApplicantPort
import com.project.gatihaeyo.internal.application.port.team.CommandTeamPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamApplicantPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamMemberPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.exception.team.AlreadyApplyTeamException
import com.project.gatihaeyo.internal.domain.exception.team.AlreadyJoinTeamException
import com.project.gatihaeyo.internal.domain.exception.team.TeamNotFoundException
import com.project.gatihaeyo.internal.domain.model.team.TeamApplicant
import java.util.UUID

@BusinessService
class ApplyTeamService(
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamApplicantPort: CommandTeamApplicantPort,
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamMemberPort: QueryTeamMemberPort,
    private val queryTeamApplicantPort: QueryTeamApplicantPort,
    private val securityService: SecurityService
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityService.getCurrentUserId()

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