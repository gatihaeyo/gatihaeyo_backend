package com.project.gatihaeyo.internal.auth.application.port

import com.project.gatihaeyo.internal.auth.domain.model.AuthCode

interface QueryAuthCodePort {

    fun queryAuthCodeByEmail(email: String): AuthCode?

}