package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.CommandTeamApplicantPort
import com.project.gatihaeyo.internal.application.port.team.CommandTeamPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamApplicantPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.exception.team.TeamApplicantNotFoundException
import com.project.gatihaeyo.internal.domain.exception.team.TeamNotFoundException
import com.project.gatihaeyo.internal.domain.exception.team.TeamPermissionException
import com.project.gatihaeyo.internal.dto.request.team.RemoveTeamApplicantRequest

@BusinessService
class RemoveTeamApplicantService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamApplicantPort: QueryTeamApplicantPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamApplicantPort: CommandTeamApplicantPort,
    private val securityService: SecurityService
) {

    fun execute(request: RemoveTeamApplicantRequest) {
        val currentUserId = securityService.getCurrentUserId()

        val team = queryTeamPort.queryTeamById(request.teamId) ?: throw TeamNotFoundException.EXCEPTION

        when {
            team.master != currentUserId -> throw TeamPermissionException.EXCEPTION

            !queryTeamApplicantPort.existsTeamApplicantByUserIdAndTeamId(request.userId, request.teamId)
                -> throw TeamApplicantNotFoundException.EXCEPTION
        }

        commandTeamApplicantPort.deleteTeamApplicantByUserIdAndTeamId(request.userId, request.teamId)

        commandTeamPort.saveTeam(
            team.copy(
                applicantPersonnel = team.applicantPersonnel.dec()
            )
        )
    }

}