package com.project.gatihaeyo.global.security.principle

import com.project.gatihaeyo.global.security.exception.InvalidTokenException
import com.project.gatihaeyo.internal.user.persistence.repository.UserJpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class AuthDetailsService(
    private val userJpaRepository: UserJpaRepository
) : UserDetailsService {

    override fun loadUserByUsername(userId: String): UserDetails {
        val id = UUID.fromString(userId)
        val user = userJpaRepository.queryUserEntityById(id) ?: throw InvalidTokenException.EXCEPTION

        return AuthDetails(
            userId = id,
            authority = user.authority
        )
    }

}