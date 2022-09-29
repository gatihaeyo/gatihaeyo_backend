package com.project.gatihaeyo.local.user.application.port

import com.project.gatihaeyo.local.user.domain.model.User

interface CommandUserPort {

    fun save(model: User): User

}