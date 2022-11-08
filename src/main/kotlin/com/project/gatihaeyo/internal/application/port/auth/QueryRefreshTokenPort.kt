package com.project.gatihaeyo.internal.application.port.auth

import com.project.gatihaeyo.internal.domain.model.auth.RefreshToken

interface QueryRefreshTokenPort {

    fun queryRefreshTokenByToken(token: String): RefreshToken?
}