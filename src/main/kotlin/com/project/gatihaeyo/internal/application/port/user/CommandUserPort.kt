package com.project.gatihaeyo.internal.application.port.user

import com.project.gatihaeyo.internal.domain.model.user.User

interface CommandUserPort {

    fun save(model: User): User

}