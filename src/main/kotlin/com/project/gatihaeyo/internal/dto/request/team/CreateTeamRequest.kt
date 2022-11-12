package com.project.gatihaeyo.internal.dto.request.team

import com.project.gatihaeyo.internal.domain.model.Category
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateTeamRequest(

    @field:NotBlank
    val title: String,

    @field:NotBlank
    val content: String,

    @field:NotNull
    val category: Category,

    @field:NotNull
    @field:Min(2)
    val personnel: Int
)