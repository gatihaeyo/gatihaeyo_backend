package com.project.gatihaeyo.internal.auth.port

import com.project.gatihaeyo.internal.auth.model.RefreshToken

interface QueryRefreshTokenPort {

    fun queryRefreshTokenByToken(token: String): RefreshToken?
}