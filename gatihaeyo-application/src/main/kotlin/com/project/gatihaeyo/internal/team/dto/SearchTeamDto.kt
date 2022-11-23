package com.project.gatihaeyo.internal.team.dto

import com.project.gatihaeyo.internal.team.OrderType

data class SearchTeamDto(
    val keyword: String,
    val order: OrderType
)