package com.project.gatihaeyo.internal.application.port.user

import com.project.gatihaeyo.internal.domain.model.user.User
import java.util.UUID

interface QueryFriendPort {

    fun queryFriendListByUserId(userId: UUID): List<User>

    fun existsFriendByUserIdAndFriendId(userId: UUID, friendId: UUID): Boolean
}