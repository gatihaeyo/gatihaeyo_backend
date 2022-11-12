package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.QueryTeamInviteePort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.exception.team.TeamNotFoundException
import com.project.gatihaeyo.internal.dto.response.team.ShowTeamInvitationResponse

@ReadOnlyBusinessService
class TeamInvitationListService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamInviteePort: QueryTeamInviteePort,
    private val securityService: SecurityService
) {

    fun execute(): ShowTeamInvitationResponse {
        val currentUserId = securityService.getCurrentUserId()

        val list = queryTeamInviteePort.queryTeamInviteesByUserId(currentUserId)

        val teams = list.map {
            queryTeamPort.queryTeamById(it.teamId) ?: throw TeamNotFoundException.EXCEPTION
        }

        return ShowTeamInvitationResponse(
            teams.map {
                ShowTeamInvitationResponse.ShowTeamInvitationElement(
                    id = it.id,
                    category = it.category,
                    title = it.title
                )
            }
        )
    }
}