package com.project.gatihaeyo.internal.team.dto.response

import com.project.gatihaeyo.internal.Category
import java.time.LocalDateTime
import java.util.UUID

data class ShowTeamResponse(
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