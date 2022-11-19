package com.project.gatihaeyo.internal.user.port

import com.project.gatihaeyo.internal.user.model.Follow
import java.util.UUID

interface CommandFollowPort {

    fun saveFollow(follow: Follow): Follow

    fun deleteFollowByUserIdAndFollowId(userId: UUID, followId: UUID)
}