package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.user.QueryFriendPort
import com.project.gatihaeyo.internal.domain.model.user.User

@ReadOnlyBusinessService
class ShowFriendService(
    private val queryFriendPort: QueryFriendPort,
    private val securityService: SecurityService
) {

    fun execute() : List<User> {
        val currentUserId = securityService.getCurrentUserId()

        return queryFriendPort.queryFriendListByUserId(currentUserId)
    }
}