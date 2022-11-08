package com.project.gatihaeyo.internal.dto.request.user

import com.project.gatihaeyo.internal.domain.model.Category
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AccountInfoRequest(
    @field:NotBlank
    val nickname: String,

    @field:NotNull
    val type: Category
)