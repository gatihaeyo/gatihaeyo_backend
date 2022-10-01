package com.project.gatihaeyo.local.token.domain.model

import com.project.gatihaeyo.local.user.domain.model.Authority
import java.util.UUID

class RefreshToken(
    val token: String,

    val userId: UUID,

    val authority: Authority,

    val expirationTime: Int
)