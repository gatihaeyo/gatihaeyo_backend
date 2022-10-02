package com.project.gatihaeyo.internal.auth.domain.model

import com.project.gatihaeyo.global.annotation.Default
import net.bytebuddy.utility.RandomString

class AuthCode @Default constructor(
    val email: String,

    val code: String,

    val expirationTime: Int
) {

    constructor(email: String) : this(
        email = email,
        code = RandomString(6).nextString(),
        expirationTime = EXPIRED
    )

    companion object {
        val EXPIRED = System.getenv("AUTHCODE_EXPIRED").toInt()
    }



}