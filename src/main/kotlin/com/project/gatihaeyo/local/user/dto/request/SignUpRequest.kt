package com.project.gatihaeyo.local.user.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class SignUpRequest(
    @field:NotBlank
    @field:Length(min = 4, max = 16)
    val nickname: String,

    @field:NotNull
    @field:Email
    val email: String,

    @field:NotBlank
    @field:Length(min = 8, max = 20)
    val password: String
)