package com.project.gatihaeyo.internal.team.model

import java.time.LocalDateTime
import java.util.UUID

data class TeamInvitee(
    val userId: UUID,

    val teamId: UUID,

    val createdAt: LocalDateTime = LocalDateTime.now()
)