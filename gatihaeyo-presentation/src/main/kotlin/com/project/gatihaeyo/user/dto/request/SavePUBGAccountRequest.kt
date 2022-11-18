package com.project.gatihaeyo.user.dto.request

import javax.validation.constraints.NotBlank

data class SavePUBGAccountRequest(
    @field:NotBlank
    val name: String,
)