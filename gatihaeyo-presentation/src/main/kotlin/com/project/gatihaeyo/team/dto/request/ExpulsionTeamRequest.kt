package com.project.gatihaeyo.team.dto.request

import java.util.UUID
import javax.validation.constraints.NotNull

data class ExpulsionTeamRequest(

    @field:NotNull
    val teamId: UUID,

    @field:NotNull
    val userId: UUID
)