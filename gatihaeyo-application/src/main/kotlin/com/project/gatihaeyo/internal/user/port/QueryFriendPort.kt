package com.project.gatihaeyo.internal.user.port

import com.project.gatihaeyo.internal.user.model.User
import java.util.UUID

interface QueryFriendPort {

    fun queryFriendListByUserId(userId: UUID): List<User>

    fun existsFriendByUserIdAndFriendId(userId: UUID, friendId: UUID): Boolean
}