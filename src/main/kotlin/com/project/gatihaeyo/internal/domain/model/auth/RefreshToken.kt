package com.project.gatihaeyo.internal.domain.model.auth

import java.util.UUID

class RefreshToken(
    val token: String,

    val userId: UUID,

    val authority: Authority,

    val expirationTime: Int
)