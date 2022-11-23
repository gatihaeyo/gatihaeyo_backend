package com.project.gatihaeyo.team.dto.request

import com.project.gatihaeyo.internal.team.OrderType
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class SearchTeamRequest(
    @field:NotBlank
    val keyword: String,

    @field:NotNull
    val order: OrderType
)