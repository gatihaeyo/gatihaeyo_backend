package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamResponse
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.port.QueryTeamPort
import java.util.UUID

@ReadOnlyBusinessService
class ShowTeamService(
    private val queryTeamPort: QueryTeamPort
) {

    fun execute(teamId: UUID): ShowTeamResponse {
        val team = queryTeamPort.queryTeamById(teamId) ?: throw TeamNotFoundException.EXCEPTION

        return ShowTeamResponse(
            id = team.id,
            master = team.master,
            category = team.category,
            title = team.title,
            content = team.content,
            personnel = team.personnel,
            currentPersonnel = team.currentPersonnel,
            applicantPersonnel = team.applicantPersonnel,
            updateAt = team.updateAt
        )
    }

}