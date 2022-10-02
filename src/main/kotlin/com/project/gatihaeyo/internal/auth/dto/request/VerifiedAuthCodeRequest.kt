package com.project.gatihaeyo.internal.auth.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class VerifiedAuthCodeRequest(
    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotBlank
    @field:Length(min = 6, max = 6)
    val code: String
)