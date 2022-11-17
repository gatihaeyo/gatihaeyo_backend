package com.project.gatihaeyo.internal.team.model

import com.project.gatihaeyo.global.Default
import java.time.LocalDateTime
import java.util.UUID

data class TeamApplicant @Default constructor(
    val userId: UUID,

    val teamId: UUID,

    val createAt: LocalDateTime
) {

    constructor(userId: UUID, teamId: UUID) : this(
        userId = userId,
        teamId = teamId,
        createAt = LocalDateTime.now()
    )

}