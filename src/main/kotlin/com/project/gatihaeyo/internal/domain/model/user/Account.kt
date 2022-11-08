package com.project.gatihaeyo.internal.domain.model.user

import com.project.gatihaeyo.internal.domain.model.Category
import java.util.UUID

data class Account(
    val userId: UUID,

    val type: Category,

    val name: String,

    val accountKey: String
)