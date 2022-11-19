package com.project.gatihaeyo.internal.user.port

import com.project.gatihaeyo.internal.user.model.User
import java.util.UUID

interface QueryFollowPort {

    fun queryFollowListByUserId(userId: UUID): List<User>

    fun existsFollowByUserIdAndFollowId(userId: UUID, followId: UUID): Boolean
}