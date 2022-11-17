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

        return team.let {
            ShowTeamResponse(
                id = it.id,
                master = it.master,
                category = it.category,
                title = it.title,
                content = it.content,
                personnel = it.personnel,
                currentPersonnel = it.currentPersonnel,
                applicantPersonnel = it.applicantPersonnel,
                updateAt = it.updateAt
            )
        }
    }

}