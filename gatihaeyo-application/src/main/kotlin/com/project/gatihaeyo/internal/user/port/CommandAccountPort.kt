package com.project.gatihaeyo.internal.user.port

import com.project.gatihaeyo.internal.user.model.Account

interface CommandAccountPort {

    fun save(entity: Account): Account

}