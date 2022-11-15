package com.project.gatihaeyo.internal.domain.model.user

import java.util.UUID

data class Friend(
    val userId: UUID,
    val friendId: UUID
)