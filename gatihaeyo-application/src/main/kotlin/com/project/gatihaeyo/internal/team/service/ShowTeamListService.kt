package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.team.dto.ShowTeamListDto
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamListResponse
import com.project.gatihaeyo.internal.team.port.QueryTeamPort

@ReadOnlyBusinessService
class ShowTeamListService(
    private val queryTeamPort: QueryTeamPort
) {

    fun execute(request: ShowTeamListDto): ShowTeamListResponse {
        val (size, page, order, category) = request

        val list = queryTeamPort.queryTeamList(
            size = size,
            page = page,
            order = order.value,
            category = category.value
        )

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