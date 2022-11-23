package com.project.gatihaeyo.internal.team.dto.response

import java.util.UUID

data class ShowTeamMemberResponse(
    val list: List<TeamMemberElement>
) {
    data class TeamMemberElement(
        val id: UUID,
        val nickname: String,
        val profileImagePath: String,
    )
}