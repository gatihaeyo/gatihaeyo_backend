package com.project.gatihaeyo.internal.user.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class SavePUBGAccountRequest(
    @field:NotBlank
    val name: String,
)