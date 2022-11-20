package com.project.gatihaeyo.global.security.principle

import com.project.gatihaeyo.internal.auth.Authority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID

class AuthDetails(
    private val userId: UUID,
    private val authority: Authority
) : UserDetails {

    override fun getAuthorities() = listOf(SimpleGrantedAuthority(authority.name))

    override fun getPassword() = null

    override fun getUsername() = userId.toString()

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}