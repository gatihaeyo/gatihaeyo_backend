package com.project.gatihaeyo.internal.user.dto.request

import com.project.gatihaeyo.internal.user.domain.model.GameType
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AccountInfoRequest(
    @field:NotBlank
    val nickname: String,

    @field:NotNull
    val type: GameType
)