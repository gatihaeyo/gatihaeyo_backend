package com.project.gatihaeyo.internal.persistence.model.user

import java.io.Serializable
import java.util.UUID

data class FriendEntityId(
    val userId: UUID,

    val friendId: UUID
) : Serializable