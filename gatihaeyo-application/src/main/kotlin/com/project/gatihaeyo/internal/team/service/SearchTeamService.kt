package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.team.dto.SearchTeamDto
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamResponse
import com.project.gatihaeyo.internal.team.port.QueryTeamPort

@ReadOnlyBusinessService
class SearchTeamService(
    private val queryTeamPort: QueryTeamPort
) {

    fun execute(request: SearchTeamDto) : List<ShowTeamResponse> {
        val list = queryTeamPort.searchTeamByKeyword(request.keyword, request.order.value)

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