package com.project.gatihaeyo.internal.user.port

import com.project.gatihaeyo.internal.Category
import com.project.gatihaeyo.internal.user.model.Account
import com.project.gatihaeyo.internal.user.model.User
import java.util.UUID

interface QueryAccountPort {

    fun queryAccountByAccountId(user: User, type: Category): Account?

    fun queryAccountByUserId(userId: UUID): List<Account>

}