package com.project.gatihaeyo.internal.user.model

import java.io.Serializable
import java.util.UUID

data class FollowEntityId(
    val userId: UUID,

    val friendId: UUID
) : Serializable