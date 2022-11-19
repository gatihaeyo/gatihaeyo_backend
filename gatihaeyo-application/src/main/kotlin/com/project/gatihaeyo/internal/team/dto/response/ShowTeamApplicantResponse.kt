package com.project.gatihaeyo.internal.team.dto.response

import java.time.LocalDateTime
import java.util.UUID

data class ShowTeamApplicantResponse(
    val list: List<ShowTeamApplicantElement>
) {
    data class ShowTeamApplicantElement(
        val id: UUID,
        val nickname: String,
        val profileImagePath: String,
        val appliedAt: LocalDateTime
    )
}