package com.project.gatihaeyo.global.security

import com.project.gatihaeyo.internal.auth.port.SecurityPort
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SecurityService(
    private val passwordEncoder: PasswordEncoder
) : SecurityPort {

    override fun compare(password: String, encryptedPassword: String): Boolean {
        return passwordEncoder.matches(password, encryptedPassword)
    }

    override fun encode(password: String): String {
        return passwordEncoder.encode(password)
    }

    override fun getCurrentUserId(): UUID {
        return UUID.fromString(
            SecurityContextHolder.getContext().authentication.name
        )
    }

}