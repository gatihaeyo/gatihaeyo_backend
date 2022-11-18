package com.project.gatihaeyo.team.dto.request

import com.project.gatihaeyo.internal.team.CategoryType
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateTeamRequest(

    @field:NotBlank
    val title: String,

    @field:NotBlank
    val content: String,

    @field:NotNull
    val category: CategoryType,

    @field:NotNull
    @field:Min(2)
    val personnel: Int
)