package com.project.gatihaeyo.internal.auth.port

import com.project.gatihaeyo.internal.auth.model.AuthCode

interface QueryAuthCodePort {

    fun queryAuthCodeByEmail(email: String): AuthCode?

}