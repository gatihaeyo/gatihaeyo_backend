package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.user.CommandFriendPort
import com.project.gatihaeyo.internal.application.port.user.QueryFriendPort
import com.project.gatihaeyo.internal.domain.exception.user.FriendNotFoundException
import java.util.UUID

@BusinessService
class RemoveFriendService(
    private val queryFriendPort: QueryFriendPort,
    private val commandFriendPort: CommandFriendPort,
    private val securityService: SecurityService
) {

    fun execute(friendId: UUID) {
        val currentUserId = securityService.getCurrentUserId()

        if (queryFriendPort.existsFriendByUserIdAndFriendId(currentUserId, friendId)) {
            throw FriendNotFoundException.EXCEPTION
        }

        commandFriendPort.deleteFriendByUserIdAndFriendId(currentUserId, friendId)
    }
}