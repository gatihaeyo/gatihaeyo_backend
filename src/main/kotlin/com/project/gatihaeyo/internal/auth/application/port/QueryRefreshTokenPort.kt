package com.project.gatihaeyo.internal.auth.application.port

import com.project.gatihaeyo.internal.auth.domain.model.RefreshToken

interface QueryRefreshTokenPort {

    fun queryRefreshTokenByToken(token: String): RefreshToken?
}