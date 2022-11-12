package com.project.gatihaeyo.internal.dto.response.team

import java.util.UUID

data class ShowTeamMemberResponse(
    val list: List<ShowTeamMemberElement>
) {
    data class ShowTeamMemberElement(
        val id: UUID,
        val nickname: String,
        val profileImagePath: String,
    )
}