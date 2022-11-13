package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.dto.request.team.ShowTeamListRequest
import com.project.gatihaeyo.internal.dto.response.team.ShowTeamListResponse

@ReadOnlyBusinessService
class ShowTeamListService(
    private val queryTeamPort: QueryTeamPort
) {

    fun execute(request: ShowTeamListRequest): ShowTeamListResponse {
        val list = queryTeamPort.queryTeamList(request.size, request.last, request.order, request.category)

        return ShowTeamListResponse(
            list.map {
                ShowTeamListResponse.ShowTeamListElement(
                    id = it.id,
                    master = it.master,
                    category = it.category,
                    title = it.title,
                    updateAt = it.updateAt,
                    personnel = it.personnel,
                    currentPersonnel = it.currentPersonnel
                )
            }
        )
    }

}