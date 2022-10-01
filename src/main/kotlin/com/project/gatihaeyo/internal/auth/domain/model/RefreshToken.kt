package com.project.gatihaeyo.internal.auth.domain.model

import com.project.gatihaeyo.internal.user.domain.model.Authority
import java.util.UUID

class RefreshToken(
    val token: String,

    val userId: UUID,

    val authority: Authority,

    val expirationTime: Int
)