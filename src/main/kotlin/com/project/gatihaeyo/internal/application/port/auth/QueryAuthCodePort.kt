package com.project.gatihaeyo.internal.application.port.auth

import com.project.gatihaeyo.internal.domain.model.user.AuthCode

interface QueryAuthCodePort {

    fun queryAuthCodeByEmail(email: String): AuthCode?

}