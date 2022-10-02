package com.project.gatihaeyo.internal.user.domain.model

import java.time.LocalDateTime
import java.util.*

class User(
    val id: UUID = UUID(0, 0),

    val nickname: String,

    val email: String,

    val password: String,

    val authority: Authority,

    val profileImagePath: String,

    val deleteAt: LocalDateTime? = null
) {
    companion object {
        val defaultProfile = System.getenv("USER_DEFAULT_PROFILE")!!
    }

    fun updatePassword(password: String) = User(
        id = this.id,
        nickname = this.nickname,
        email = this.email,
        password = password,
        authority = this.authority,
        profileImagePath = this.profileImagePath,
        deleteAt = this.deleteAt
    )

    fun updateInfo(nickname: String?, profileImagePath: String?) = User(
        id = this.id,
        nickname = nickname ?: this.nickname,
        email = this.email,
        password = this.password,
        authority = this.authority,
        profileImagePath = profileImagePath ?: this.profileImagePath,
        deleteAt = this.deleteAt
    )

}