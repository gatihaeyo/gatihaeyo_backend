package com.project.gatihaeyo.internal.dto.request.team

import java.util.UUID
import javax.validation.constraints.NotNull

data class ExpulsionTeamRequest(

    @field:NotNull
    val teamId: UUID,

    @field:NotNull
    val userId: UUID
)