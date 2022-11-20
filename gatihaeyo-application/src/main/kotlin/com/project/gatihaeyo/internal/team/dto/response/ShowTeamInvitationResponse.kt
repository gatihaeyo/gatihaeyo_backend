package com.project.gatihaeyo.internal.team.dto.response

import com.project.gatihaeyo.internal.team.Category
import java.time.LocalDateTime
import java.util.UUID

data class ShowTeamInvitationResponse(
    val list: List<ShowTeamInvitationElement>
) {
    data class ShowTeamInvitationElement(
        val id: UUID,
        val title: String,
        val category: Category,
        val invitedAt: LocalDateTime
    )
}