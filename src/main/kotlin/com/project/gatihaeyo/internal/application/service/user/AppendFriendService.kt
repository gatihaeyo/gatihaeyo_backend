package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.user.CommandFriendPort
import com.project.gatihaeyo.internal.application.port.user.QueryFriendPort
import com.project.gatihaeyo.internal.domain.exception.user.AlreadyFriendException
import com.project.gatihaeyo.internal.domain.exception.user.CannotMakeFriendAloneException
import com.project.gatihaeyo.internal.domain.model.user.Friend
import java.util.UUID

@BusinessService
class AppendFriendService(
    private val queryFriendPort: QueryFriendPort,
    private val commandFriendPort: CommandFriendPort,
    private val securityService: SecurityService
) {

    fun execute(friendId: UUID) {
        val currentUserId = securityService.getCurrentUserId()

        when {
            currentUserId == friendId -> throw CannotMakeFriendAloneException.EXCEPTION
            !queryFriendPort.existsFriendByUserIdAndFriendId(currentUserId, friendId) -> throw AlreadyFriendException.EXCEPTION
        }

        commandFriendPort.saveFriend(
            Friend(
                userId = currentUserId,
                friendId = friendId
            )
        )
    }
}