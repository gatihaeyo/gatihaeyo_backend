package com.project.gatihaeyo.local.user.application.port

import com.project.gatihaeyo.local.user.domain.model.User
import java.util.UUID

interface QueryUserPort {

    fun queryUserById(id: UUID): User?

}