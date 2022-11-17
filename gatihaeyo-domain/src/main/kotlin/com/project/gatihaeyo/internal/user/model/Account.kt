package com.project.gatihaeyo.internal.user.model

import com.project.gatihaeyo.internal.Category
import java.util.UUID

data class Account(
    val userId: UUID,

    val type: Category,

    val name: String,

    val accountKey: String
)