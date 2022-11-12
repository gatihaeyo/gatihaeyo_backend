package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.QueryTeamInviteePort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.exception.team.TeamNotFoundException
import com.project.gatihaeyo.internal.dto.response.team.ShowTeamInvitationResponse

@ReadOnlyBusinessService
class ShowTeamInvitationService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamInviteePort: QueryTeamInviteePort,
    private val securityService: SecurityService
) {

    fun execute(): ShowTeamInvitationResponse {
        val currentUserId = securityService.getCurrentUserId()

        val list = queryTeamInviteePort.queryTeamInviteesByUserId(currentUserId)

        return ShowTeamInvitationResponse(
            list.map {
                queryTeamPort.queryTeamById(it.teamId)?.let { team ->
                    ShowTeamInvitationResponse.ShowTeamInvitationElement(
                        id = team.id,
                        category = team.category,
                        title = team.title,
                        inviteAt = it.createAt
                    )
                } ?: throw TeamNotFoundException.EXCEPTION
            }
        )
    }
}