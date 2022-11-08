package com.project.gatihaeyo.internal.application.port.auth

import com.project.gatihaeyo.internal.domain.model.user.AuthCode

interface CommandAuthCodePort {

    fun save(code: AuthCode): AuthCode

}