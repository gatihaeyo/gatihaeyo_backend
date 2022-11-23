package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.team.dto.ShowTeamListDto
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamPageResponse
import com.project.gatihaeyo.internal.team.port.QueryTeamPort

@ReadOnlyBusinessService
class ShowTeamPageService(
    private val queryTeamPort: QueryTeamPort
) {

    fun execute(request: ShowTeamListDto): ShowTeamPageResponse {
        val (size, page, order, category) = request

        val list = queryTeamPort.queryTeamPage(
            size = size,
            page = page,
            order = order.value,
            category = category.value
        )

        return ShowTeamPageResponse(
            list.map {
                ShowTeamPageResponse.TeamPageElement(
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