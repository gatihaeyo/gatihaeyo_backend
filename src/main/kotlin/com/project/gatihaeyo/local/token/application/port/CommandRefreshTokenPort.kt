package com.project.gatihaeyo.local.token.application.port

import com.project.gatihaeyo.local.token.domain.model.RefreshToken

interface CommandRefreshTokenPort {

    fun save(token: RefreshToken): RefreshToken

}