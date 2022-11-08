package com.project.gatihaeyo.internal.application.port.user

import com.project.gatihaeyo.internal.domain.model.user.Account
import com.project.gatihaeyo.internal.domain.model.Category
import com.project.gatihaeyo.internal.domain.model.user.User
import java.util.UUID

interface QueryAccountPort {

    fun queryAccountByAccountId(user: User, type: Category): Account?

    fun queryAccountByUserId(userId: UUID): List<Account>

}