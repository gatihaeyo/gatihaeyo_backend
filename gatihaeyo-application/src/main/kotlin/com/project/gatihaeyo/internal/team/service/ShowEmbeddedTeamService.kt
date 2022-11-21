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

        val list = queryTeamMemberPort.queryTeamMemberByUserId(currentUserId)
            .map {
                queryTeamPort.queryTeamById(it.teamId) ?: throw TeamNotFoundException.EXCEPTION
            }

        return list.map {
            ShowTeamResponse(
                id = it.id,
                master = it.master,
                title = it.title,
                content = it.content,
                category = it.category,
                personnel = it.personnel,
                currentPersonnel = it.currentPersonnel,
                applicantPersonnel = it.applicantPersonnel,
                updateAt = it.updateAt
            )
        }
    }
}