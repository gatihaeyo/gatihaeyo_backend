package com.project.gatihaeyo.internal.auth.application.port

import com.project.gatihaeyo.internal.auth.domain.model.AuthCode

interface CommandAuthCodePort {

    fun save(code: AuthCode): AuthCode

}