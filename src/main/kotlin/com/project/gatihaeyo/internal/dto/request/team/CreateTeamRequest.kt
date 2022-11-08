package com.project.gatihaeyo.internal.dto.request.team

import com.project.gatihaeyo.internal.domain.model.Category
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class CreateTeamRequest(

    @field:NotBlank
    val title: String,

    @field:NotNull
    val category: Category,

    @field:Positive
    @field:NotNull
    val personnel: Int
)