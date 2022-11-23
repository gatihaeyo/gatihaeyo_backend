package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamResponse
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.port.QueryTeamMemberPort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort

@ReadOnlyBusinessService
class ShowEmbeddedTeamService(
    private val queryTeamMemberPort: QueryTeamMemberPort,
    private val queryTeamPort: QueryTeamPort,
    private val securityPort: SecurityPort
) {

    fun execute() : List<ShowTeamResponse> {
        val currentUserId = securityPort.getCurrentUserId()

        return queryTeamMemberPort.queryTeamMemberByUserId(currentUserId)
            .map {
                val team = queryTeamPort.queryTeamById(it.teamId) ?: throw TeamNotFoundException.EXCEPTION

                ShowTeamResponse(
                    id = team.id,
                    master = team.master,
                    title = team.title,
                    content = team.content,
                    category = team.category,
                    personnel = team.personnel,
                    currentPersonnel = team.currentPersonnel,
                    applicantPersonnel = team.applicantPersonnel,
                    updateAt = team.updateAt
                )
            }
    }
}