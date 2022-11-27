package com.project.gatihaeyo.internal.team.dto.response

import com.project.gatihaeyo.internal.team.Category
import java.time.LocalDateTime
import java.util.UUID

data class ShowTeamApplyResponse(
    val list: List<ShowTeamApplyElement>
) {
    data class ShowTeamApplyElement(
        val id: UUID,
        val title: String,
        val category: Category,
        val appliedAt: LocalDateTime
    )
}