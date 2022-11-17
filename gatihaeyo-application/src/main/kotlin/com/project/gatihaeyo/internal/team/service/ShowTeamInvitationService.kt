package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamInvitationResponse
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.port.QueryTeamInviteePort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort

@ReadOnlyBusinessService
class ShowTeamInvitationService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamInviteePort: QueryTeamInviteePort,
    private val securityPort: SecurityPort
) {

    fun execute(): ShowTeamInvitationResponse {
        val currentUserId = securityPort.getCurrentUserId()

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