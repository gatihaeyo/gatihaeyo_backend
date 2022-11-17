package com.project.gatihaeyo.internal.user.port

import com.project.gatihaeyo.internal.user.model.Friend
import java.util.UUID

interface CommandFriendPort {

    fun saveFriend(friend: Friend): Friend

    fun deleteFriendByUserIdAndFriendId(userId: UUID, friendId: UUID)
}