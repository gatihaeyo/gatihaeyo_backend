package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.CommandTeamMemberPort
import com.project.gatihaeyo.internal.application.port.team.CommandTeamPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamApplicantPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamMemberPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.exception.team.AlreadyJoinTeamException
import com.project.gatihaeyo.internal.domain.exception.team.TeamApplicantNotFoundException
import com.project.gatihaeyo.internal.domain.exception.team.TeamFullPersonnelException
import com.project.gatihaeyo.internal.domain.exception.team.TeamNotFoundException
import com.project.gatihaeyo.internal.domain.exception.team.TeamPermissionException
import com.project.gatihaeyo.internal.domain.model.team.TeamMember
import com.project.gatihaeyo.internal.dto.request.team.ReceiveTeamApplicantRequest

@BusinessService
class ReceiveTeamApplicantService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamApplicantPort: QueryTeamApplicantPort,
    private val queryTeamMemberPort: QueryTeamMemberPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val securityService: SecurityService
) {

    fun execute(request: ReceiveTeamApplicantRequest) {
        val currentUserId = securityService.getCurrentUserId()

        val team = queryTeamPort.queryTeamById(request.teamId) ?: throw TeamNotFoundException.EXCEPTION

        when {
            currentUserId != team.master -> throw TeamPermissionException.EXCEPTION

            team.personnel < team.currentPersonnel.inc() -> throw TeamFullPersonnelException.EXCEPTION

            !queryTeamApplicantPort.existsTeamApplicantByUserIdAndTeamId(request.userId, request.teamId)
                    -> throw TeamApplicantNotFoundException.EXCEPTION

            queryTeamMemberPort.existsTeamMemberByUserIdAndTeamId(request.userId, request.teamId)
                    -> throw AlreadyJoinTeamException.EXCEPTION
        }

        commandTeamMemberPort.saveTeamMember(
            TeamMember(
                userId = request.userId,
                teamId = request.teamId
            )
        )

        commandTeamPort.saveTeam(
            team.copy(
                currentPersonnel = team.currentPersonnel.inc()
            )
        )
    }

}