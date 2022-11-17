package com.project.gatihaeyo.internal.user.port

import com.project.gatihaeyo.internal.user.model.User

interface CommandUserPort {

    fun saveUser(user: User): User

}