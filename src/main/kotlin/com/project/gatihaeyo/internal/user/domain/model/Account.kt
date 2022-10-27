package com.project.gatihaeyo.internal.user.domain.model

import java.util.UUID

data class Account(
    val userId: UUID,

    val type: GameType,

    val name: String,

    val accountKey: String
)