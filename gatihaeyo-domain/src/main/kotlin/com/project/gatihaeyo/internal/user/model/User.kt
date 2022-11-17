package com.project.gatihaeyo.internal.user.model

import com.project.gatihaeyo.internal.auth.model.Authority
import java.lang.System.getenv
import java.time.LocalDateTime
import java.util.UUID

data class User(
    val id: UUID = UUID(0, 0),

    val nickname: String,

    val email: String,

    val password: String,

    val authority: Authority,

    val profileImagePath: String,

    val deleteAt: LocalDateTime? = null,

    val friendCount: Int = 0
) {
    companion object {
        @JvmField
        val DEFAULT_IMAGE = getenv("USER_DEFAULT_PROFILE")!!
    }

}