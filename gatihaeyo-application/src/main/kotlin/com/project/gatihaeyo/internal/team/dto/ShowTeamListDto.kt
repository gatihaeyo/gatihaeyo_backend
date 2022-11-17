package com.project.gatihaeyo.internal.team.dto

import com.project.gatihaeyo.internal.team.CategoryType
import com.project.gatihaeyo.internal.team.OrderType

data class ShowTeamListDto(
    val size: Int,

    val page: Long,

    val order: OrderType,

    val category: CategoryType
)