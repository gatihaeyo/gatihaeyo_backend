package com.project.gatihaeyo.local.user.domain.model

import java.time.LocalDateTime
import java.util.*

class User(
    val id: UUID = UUID(0, 0),

    val nickname: String,

    val email: String,

    val password: String,

    val deleteAt: LocalDateTime?
)