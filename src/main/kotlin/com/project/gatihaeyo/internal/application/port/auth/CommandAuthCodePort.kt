package com.project.gatihaeyo.internal.application.port.auth

import com.project.gatihaeyo.internal.domain.model.auth.AuthCode

interface CommandAuthCodePort {

    fun save(code: AuthCode): AuthCode

}