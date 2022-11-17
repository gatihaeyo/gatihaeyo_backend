package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.user.dto.response.UserResponse
import com.project.gatihaeyo.internal.user.port.QueryFriendPort

@ReadOnlyBusinessService
class ShowFollowService(
    private val queryFriendPort: QueryFriendPort,
    private val securityPort: SecurityPort
) {

    fun execute() : List<UserResponse> {
        val currentUserId = securityPort.getCurrentUserId()

        return queryFriendPort.queryFriendListByUserId(currentUserId).map {
            UserResponse(
                id = it.id,
                nickname = it.nickname,
                email = it.email,
                profileImagePath = it.profileImagePath
            )
        }
    }
}