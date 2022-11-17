package com.project.gatihaeyo.internal.auth.port

import java.util.UUID

interface SecurityPort {

    fun getCurrentUserId(): UUID

    fun encode(password: String): String

    fun compare(password: String, encryptedPassword: String): Boolean
}