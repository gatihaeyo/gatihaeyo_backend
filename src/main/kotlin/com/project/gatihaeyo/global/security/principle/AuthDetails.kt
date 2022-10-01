package com.project.gatihaeyo.global.security.principle

import com.project.gatihaeyo.internal.user.domain.model.Authority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class AuthDetails(
    private val userId: UUID,
    private val authority: Authority
) : UserDetails {

    override fun getAuthorities() = listOf(authority)

    override fun getPassword() = null

    override fun getUsername() = userId.toString()

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}