package com.project.gatihaeyo.internal.user.application.port

import com.project.gatihaeyo.internal.user.domain.model.User

interface CommandUserPort {

    fun save(model: User): User

}