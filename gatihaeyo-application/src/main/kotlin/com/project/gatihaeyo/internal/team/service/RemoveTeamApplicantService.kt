package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.dto.RemoveTeamApplicantDto
import com.project.gatihaeyo.internal.team.exception.TeamApplicantNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamPermissionException
import com.project.gatihaeyo.internal.team.port.CommandTeamApplicantPort
import com.project.gatihaeyo.internal.team.port.CommandTeamPort
import com.project.gatihaeyo.internal.team.port.QueryTeamApplicantPort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort

@BusinessService
class RemoveTeamApplicantService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamApplicantPort: QueryTeamApplicantPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamApplicantPort: CommandTeamApplicantPort,
    private val securityPort: SecurityPort
) {

    fun execute(request: RemoveTeamApplicantDto) {
        val currentUserId = securityPort.getCurrentUserId()

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