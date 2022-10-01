package com.project.gatihaeyo.internal.auth.application.port

interface SendAuthCodePort {

    fun sendAuthCode(code: String, email: String)

}