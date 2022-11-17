package com.project.gatihaeyo.internal.team.dto

import com.project.gatihaeyo.internal.team.CategoryType

data class CreateTeamDto(
    val title: String,
    val content: String,
    val category: CategoryType,
    val personnel: Int
)