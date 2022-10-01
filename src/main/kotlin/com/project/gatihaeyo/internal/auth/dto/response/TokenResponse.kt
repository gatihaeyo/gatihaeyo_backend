package com.project.gatihaeyo.internal.auth.dto.response

import java.util.Date

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessExpiredTime: Date
)