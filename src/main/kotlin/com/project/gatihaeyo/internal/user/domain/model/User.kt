package com.project.gatihaeyo.internal.user.domain.model

import java.lang.System.getenv
import java.time.LocalDateTime
import java.util.*

data class User(
    val id: UUID = UUID(0, 0),

    val nickname: String,

    val email: String,

    val password: String,

    val authority: Authority,

    val profileImagePath: String,

    val deleteAt: LocalDateTime? = null
) {
    companion object {
        @JvmField
        val defaultProfile = getenv("USER_DEFAULT_PROFILE")!!
    }

}