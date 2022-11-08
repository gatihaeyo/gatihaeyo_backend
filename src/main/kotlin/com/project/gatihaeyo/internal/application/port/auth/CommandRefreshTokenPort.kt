package com.project.gatihaeyo.internal.application.port.auth

import com.project.gatihaeyo.internal.domain.model.auth.RefreshToken

interface CommandRefreshTokenPort {

    fun save(token: RefreshToken): RefreshToken

}