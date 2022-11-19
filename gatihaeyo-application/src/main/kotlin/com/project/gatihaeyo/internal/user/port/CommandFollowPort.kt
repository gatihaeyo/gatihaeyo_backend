package com.project.gatihaeyo.internal.user.port

import com.project.gatihaeyo.internal.user.model.Follow
import java.util.UUID

interface CommandFollowPort {

    fun saveFollow(friend: Follow): Follow

    fun deleteFollowByUserIdAndFollowId(userId: UUID, friendId: UUID)
}