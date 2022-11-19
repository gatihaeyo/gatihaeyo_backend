package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.user.exception.AlreadyFriendException
import com.project.gatihaeyo.internal.user.exception.CannotFollowAloneException
import com.project.gatihaeyo.internal.user.model.Follow
import com.project.gatihaeyo.internal.user.port.CommandFollowPort
import com.project.gatihaeyo.internal.user.port.QueryFollowPort
import java.util.UUID

@BusinessService
class AppendFollowService(
    private val queryFollowPort: QueryFollowPort,
    private val commandFollowPort: CommandFollowPort,
    private val securityPort: SecurityPort
) {

    fun execute(friendId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()

        when {
            currentUserId == friendId -> throw CannotFollowAloneException.EXCEPTION

            !queryFollowPort.existsFollowByUserIdAndFollowId(currentUserId, friendId)
                -> throw AlreadyFriendException.EXCEPTION
        }

        commandFollowPort.saveFollow(
            Follow(
                userId = currentUserId,
                followId = friendId
            )
        )
    }
}