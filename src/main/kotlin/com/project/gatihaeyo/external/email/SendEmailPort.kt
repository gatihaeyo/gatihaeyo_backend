package com.project.gatihaeyo.external.email

interface SendEmailPort {

    fun sendAuthCode(code: String, email: String)

}