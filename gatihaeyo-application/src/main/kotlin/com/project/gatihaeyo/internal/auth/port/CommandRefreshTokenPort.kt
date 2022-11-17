package com.project.gatihaeyo.internal.auth.port

import com.project.gatihaeyo.internal.auth.model.RefreshToken

interface CommandRefreshTokenPort {

    fun save(token: RefreshToken): RefreshToken

}