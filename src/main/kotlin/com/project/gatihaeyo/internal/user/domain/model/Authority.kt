package com.project.gatihaeyo.internal.user.domain.model

import org.springframework.security.core.GrantedAuthority

enum class Authority : GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    override fun getAuthority() = this.name
}