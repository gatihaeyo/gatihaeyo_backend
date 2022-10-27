package com.project.gatihaeyo.internal.user.application.port

import com.project.gatihaeyo.internal.user.domain.model.Account
import com.project.gatihaeyo.internal.user.domain.model.GameType
import com.project.gatihaeyo.internal.user.domain.model.User

interface QueryAccountPort {

    fun queryAccountByAccountId(user: User, type: GameType): Account?

}