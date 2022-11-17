package com.project.gatihaeyo.internal.team.dto

import java.util.UUID

data class ReceiveTeamApplicantDto(
    val userId: UUID,
    val teamId: UUID
)