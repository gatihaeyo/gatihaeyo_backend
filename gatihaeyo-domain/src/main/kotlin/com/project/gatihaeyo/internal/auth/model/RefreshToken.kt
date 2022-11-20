package com.project.gatihaeyo.internal.auth.model

import com.project.gatihaeyo.internal.auth.Authority
import java.util.UUID

class RefreshToken(
    val token: String,

    val userId: UUID,

    val authority: Authority,

    val expirationTime: Int
)