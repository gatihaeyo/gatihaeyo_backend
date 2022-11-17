package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.user.exception.AlreadyFriendException
import com.project.gatihaeyo.internal.user.exception.CannotMakeFriendAloneException
import com.project.gatihaeyo.internal.user.model.Friend
import com.project.gatihaeyo.internal.user.port.CommandFriendPort
import com.project.gatihaeyo.internal.user.port.QueryFriendPort
import java.util.UUID

@BusinessService
class AppendFollowService(
    private val queryFriendPort: QueryFriendPort,
    private val commandFriendPort: CommandFriendPort,
    private val securityPort: SecurityPort
) {

    fun execute(friendId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()

        when {
            currentUserId == friendId -> throw CannotMakeFriendAloneException.EXCEPTION

            !queryFriendPort.existsFriendByUserIdAndFriendId(currentUserId, friendId)
                -> throw AlreadyFriendException.EXCEPTION
        }

        commandFriendPort.saveFriend(
            Friend(
                userId = currentUserId,
                friendId = friendId
            )
        )
    }
}