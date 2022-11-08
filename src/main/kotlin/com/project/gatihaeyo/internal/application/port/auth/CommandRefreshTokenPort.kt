package com.project.gatihaeyo.internal.application.port.auth

import com.project.gatihaeyo.internal.domain.model.user.RefreshToken

interface CommandRefreshTokenPort {

    fun save(token: RefreshToken): RefreshToken

}