package com.project.gatihaeyo.global.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SecurityService(
    private val passwordEncoder: PasswordEncoder
) {

    fun compare(password: String, encryptedPassword: String): Boolean {
        return passwordEncoder.matches(password, encryptedPassword)
    }

    fun encode(password: String): String {
        return passwordEncoder.encode(password)
    }

    fun getCurrentUserId(): UUID {
        return UUID.fromString(
            SecurityContextHolder.getContext().authentication.name
        )
    }

}