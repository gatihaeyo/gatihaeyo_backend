package com.project.gatihaeyo.user.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class ChangePasswordRequest(
    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotBlank
    @field:Length(min = 6, max = 6)
    val code: String,

    @field:NotBlank
    @field:Length(min = 8, max = 20)
    val newPassword: String
)