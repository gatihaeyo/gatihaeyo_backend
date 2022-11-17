package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.dto.ReceiveTeamApplicantDto
import com.project.gatihaeyo.internal.team.exception.AlreadyJoinTeamException
import com.project.gatihaeyo.internal.team.exception.TeamApplicantNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamFullPersonnelException
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamPermissionException
import com.project.gatihaeyo.internal.team.model.TeamMember
import com.project.gatihaeyo.internal.team.port.CommandTeamMemberPort
import com.project.gatihaeyo.internal.team.port.CommandTeamPort
import com.project.gatihaeyo.internal.team.port.QueryTeamApplicantPort
import com.project.gatihaeyo.internal.team.port.QueryTeamMemberPort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort

@BusinessService
class ReceiveTeamApplicantService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamApplicantPort: QueryTeamApplicantPort,
    private val queryTeamMemberPort: QueryTeamMemberPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val securityPort: SecurityPort
) {

    fun execute(request: ReceiveTeamApplicantDto) {
        val currentUserId = securityPort.getCurrentUserId()

        val team = queryTeamPort.queryTeamById(request.teamId) ?: throw TeamNotFoundException.EXCEPTION

        when {
            currentUserId != team.master -> throw TeamPermissionException.EXCEPTION

            team.personnel <= team.currentPersonnel -> throw TeamFullPersonnelException.EXCEPTION

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