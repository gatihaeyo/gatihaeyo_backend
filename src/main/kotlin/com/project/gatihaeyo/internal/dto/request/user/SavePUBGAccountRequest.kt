package com.project.gatihaeyo.internal.dto.request.user

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class SavePUBGAccountRequest(
    @field:NotBlank
    val name: String,
)