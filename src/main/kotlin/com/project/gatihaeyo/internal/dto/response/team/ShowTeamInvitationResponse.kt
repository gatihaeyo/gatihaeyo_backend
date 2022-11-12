package com.project.gatihaeyo.internal.dto.response.team

import com.project.gatihaeyo.internal.domain.model.Category
import java.util.UUID

data class ShowTeamInvitationResponse(
    val list: List<ShowTeamInvitationElement>
) {
    data class ShowTeamInvitationElement(
        val id: UUID,
        val title: String,
        val category: Category
    )
}