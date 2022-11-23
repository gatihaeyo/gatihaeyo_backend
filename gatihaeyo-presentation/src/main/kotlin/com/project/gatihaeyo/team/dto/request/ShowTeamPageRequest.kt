package com.project.gatihaeyo.team.dto.request

import com.project.gatihaeyo.internal.team.CategoryType
import com.project.gatihaeyo.internal.team.OrderType
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class ShowTeamPageRequest(

    @field:NotNull
    val size: Int = 8,

    @field:NotNull
    val category: CategoryType = CategoryType.LEAGUEOFLEGEND,

    @field:NotNull
    val order: OrderType = OrderType.RECENT,

    @field:NotNull
    @field:Positive
    val page: Long = 1
)