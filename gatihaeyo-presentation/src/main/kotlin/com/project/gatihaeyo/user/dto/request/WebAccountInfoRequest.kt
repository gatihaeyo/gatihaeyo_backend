package com.project.gatihaeyo.user.dto.request

import com.project.gatihaeyo.internal.team.CategoryType
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class WebAccountInfoRequest(
    @field:NotBlank
    val nickname: String,

    @field:NotNull
    val type: CategoryType
)