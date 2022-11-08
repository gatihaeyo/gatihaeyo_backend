package com.project.gatihaeyo.internal.dto.response.auth

import java.util.Date

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessExpiredTime: Date
)