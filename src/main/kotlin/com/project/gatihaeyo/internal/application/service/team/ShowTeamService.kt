package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.exception.team.TeamNotFoundException
import com.project.gatihaeyo.internal.dto.response.team.ShowTeamResponse
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