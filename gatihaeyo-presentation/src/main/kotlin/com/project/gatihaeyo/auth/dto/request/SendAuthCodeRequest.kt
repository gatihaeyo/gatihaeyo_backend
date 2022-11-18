package com.project.gatihaeyo.auth.dto.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

data class SendAuthCodeRequest(
    @field:NotNull
    @field:Email
    val email: String
)