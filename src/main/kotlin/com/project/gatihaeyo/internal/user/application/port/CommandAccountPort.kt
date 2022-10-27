package com.project.gatihaeyo.internal.user.application.port

import com.project.gatihaeyo.internal.user.domain.model.Account

interface CommandAccountPort {

    fun save(entity: Account): Account

}