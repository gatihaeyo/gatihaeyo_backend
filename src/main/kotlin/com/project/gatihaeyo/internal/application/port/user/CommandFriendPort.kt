package com.project.gatihaeyo.internal.application.port.user

import com.project.gatihaeyo.internal.domain.model.user.Friend
import java.util.UUID

interface CommandFriendPort {

    fun saveFriend(friend: Friend): Friend

    fun deleteFriendByUserIdAndFriendId(userId: UUID, friendId: UUID)
}