package com.project.gatihaeyo.internal.application.port.auth

import com.project.gatihaeyo.internal.domain.model.auth.AuthCode

interface QueryAuthCodePort {

    fun queryAuthCodeByEmail(email: String): AuthCode?

}