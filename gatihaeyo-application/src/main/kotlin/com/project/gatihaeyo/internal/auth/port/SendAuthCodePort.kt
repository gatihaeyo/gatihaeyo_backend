package com.project.gatihaeyo.internal.auth.port

interface SendAuthCodePort {

    fun sendAuthCode(code: String, email: String)

}