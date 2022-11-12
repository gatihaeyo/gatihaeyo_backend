package com.project.gatihaeyo.internal.dto.response.team

import com.project.gatihaeyo.internal.domain.model.Category
import java.time.LocalDateTime
import java.util.UUID

data class ShowTeamResponse(
    val list: List<ShowTeamElement>
) {
    data class ShowTeamElement(
        val id: UUID,
        val master: UUID,
        val title: String,
        val content: String,
        val category: Category,
        val personnel: Int,
        val currentPersonnel: Int,
        val applicantPersonnel: Int,
        val updateAt: LocalDateTime
    )
}