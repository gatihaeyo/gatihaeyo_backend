package com.project.gatihaeyo.local.token.dto.response

import java.util.Date

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessExpiredTime: Date
)