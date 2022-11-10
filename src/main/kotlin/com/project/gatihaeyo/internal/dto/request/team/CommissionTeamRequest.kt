package com.project.gatihaeyo.internal.dto.request.team

import java.util.UUID
import javax.validation.constraints.NotNull

data class CommissionTeamRequest(

    @field:NotNull
    val userId: UUID,

    @field:NotNull
    val teamId: UUID
)