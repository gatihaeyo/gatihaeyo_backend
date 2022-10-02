package com.project.gatihaeyo.internal.user.application.port

import com.project.gatihaeyo.internal.user.domain.model.User
import java.util.UUID

interface QueryUserPort {

    fun queryUserById(id: UUID): User?

    fun queryUserByNickname(nickname: String): User?

    fun queryUserByEmail(email: String): User?

    fun existsUserByEmail(email: String): Boolean

    fun existsUserByNickname(nickname: String): Boolean

}