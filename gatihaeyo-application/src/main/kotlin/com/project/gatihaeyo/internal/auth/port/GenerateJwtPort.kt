package com.project.gatihaeyo.internal.auth.port

import com.project.gatihaeyo.internal.auth.model.Authority
import com.project.gatihaeyo.internal.auth.dto.response.TokenResponse
import java.util.UUID

interface GenerateJwtPort {

    fun issuanceToken(userId: UUID, authority: Authority): TokenResponse
}