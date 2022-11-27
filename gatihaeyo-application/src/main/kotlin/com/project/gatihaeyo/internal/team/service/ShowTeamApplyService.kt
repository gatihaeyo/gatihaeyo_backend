package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamApplyResponse
import com.project.gatihaeyo.internal.team.port.QueryTeamApplicantPort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException

@ReadOnlyBusinessService
class ShowTeamApplyService(
    private val queryTeamApplicantPort: QueryTeamApplicantPort,
    private val queryTeamPort: QueryTeamPort,
    private val securityPort: SecurityPort
) {

    fun execute(): ShowTeamApplyResponse {
        val currentUserId = securityPort.getCurrentUserId()

        val list = queryTeamApplicantPort.queryTeamApplicantListByUserId(currentUserId)

        return ShowTeamApplyResponse(
            list.map {
                queryTeamPort.queryTeamById(it.teamId)?.let { team ->
                    ShowTeamApplyResponse.ShowTeamApplyElement(
                        id = team.id,
                        title = team.title,
                        category = team.category,
                        appliedAt = it.createdAt
                    )
                } ?: throw UserNotFoundException.EXCEPTION
            }
        )
    }
}