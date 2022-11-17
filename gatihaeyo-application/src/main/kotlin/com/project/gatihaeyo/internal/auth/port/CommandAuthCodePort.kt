package com.project.gatihaeyo.internal.auth.port

import com.project.gatihaeyo.internal.auth.model.AuthCode

interface CommandAuthCodePort {

    fun save(code: AuthCode): AuthCode

}