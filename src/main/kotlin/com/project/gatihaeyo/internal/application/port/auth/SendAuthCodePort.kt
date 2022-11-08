package com.project.gatihaeyo.internal.application.port.auth

interface SendAuthCodePort {

    fun sendAuthCode(code: String, email: String)

}