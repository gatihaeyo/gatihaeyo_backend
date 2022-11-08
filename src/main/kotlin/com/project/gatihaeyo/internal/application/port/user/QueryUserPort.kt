package com.project.gatihaeyo.internal.application.port.user

import com.project.gatihaeyo.internal.domain.model.user.User
import java.util.UUID

interface QueryUserPort {

    fun queryUserById(id: UUID): User?

    fun queryUserByNickname(nickname: String): User?

    fun queryUserByEmail(email: String): User?

    fun existsUserByEmail(email: String): Boolean

    fun existsUserByNickname(nickname: String): Boolean

    fun queryUserListByNickname(nickname: String): List<User>

}