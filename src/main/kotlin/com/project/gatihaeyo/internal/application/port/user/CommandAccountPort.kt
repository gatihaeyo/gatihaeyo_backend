package com.project.gatihaeyo.internal.application.port.user

import com.project.gatihaeyo.internal.domain.model.user.Account

interface CommandAccountPort {

    fun save(entity: Account): Account

}