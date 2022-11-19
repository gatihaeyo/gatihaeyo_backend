package com.project.gatihaeyo.internal.user.model

import java.util.UUID

data class Follow(
    val userId: UUID,
    val followId: UUID
)