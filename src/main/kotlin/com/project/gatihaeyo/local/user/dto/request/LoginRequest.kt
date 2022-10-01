package com.project.gatihaeyo.local.user.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlank
    val nickname: String,

    @field:NotBlank
    @field:Length(min = 8, max = 20)
    val password: String
)