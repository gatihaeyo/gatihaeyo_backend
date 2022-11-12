package com.project.gatihaeyo.internal.dto.request.team

import com.project.gatihaeyo.internal.domain.model.Category
import com.project.gatihaeyo.internal.domain.model.Order
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

data class ShowTeamListRequest(

    @field:NotNull
    val size: Int = 8,

    @field:NotNull
    val category: Category = Category.LOL,

    @field:NotNull
    val order: Order = Order.RECENT,

    @field:NotNull
    val last: LocalDateTime
)