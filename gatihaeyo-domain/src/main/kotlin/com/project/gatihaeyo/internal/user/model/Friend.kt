package com.project.gatihaeyo.internal.user.model

import java.util.UUID

data class Friend(
    val userId: UUID,
    val friendId: UUID
)