package com.project.gatihaeyo.internal.dto.response.team

import com.project.gatihaeyo.internal.domain.model.Category
import java.time.LocalDateTime
import java.util.UUID

data class ShowTeamListResponse(
    val list: List<ShowTeamListElement>
) {
    data class ShowTeamListElement(
        val id: UUID,
        val master: UUID,
        val title: String,
        val category: Category,
        val personnel: Int,
        val currentPersonnel: Int,
        val updateAt: LocalDateTime
    )

}