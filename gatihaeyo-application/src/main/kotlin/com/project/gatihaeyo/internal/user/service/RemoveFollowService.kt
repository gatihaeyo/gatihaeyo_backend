package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.user.exception.FriendNotFoundException
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.port.CommandFriendPort
import com.project.gatihaeyo.internal.user.port.CommandUserPort
import com.project.gatihaeyo.internal.user.port.QueryFriendPort
import com.project.gatihaeyo.internal.user.port.QueryUserPort
import java.util.UUID

@BusinessService
class RemoveFollowService(
    private val queryFriendPort: QueryFriendPort,
    private val queryUserPort: QueryUserPort,
    private val commandFriendPort: CommandFriendPort,
    private val commandUserPort: CommandUserPort,
    private val securityPort: SecurityPort
) {

    fun execute(friendId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()

        val user = queryUserPort.queryUserById(friendId) ?: throw UserNotFoundException.EXCEPTION

        if (!queryFriendPort.existsFriendByUserIdAndFriendId(currentUserId, friendId)) {
            throw FriendNotFoundException.EXCEPTION
        }

        commandFriendPort.deleteFriendByUserIdAndFriendId(currentUserId, friendId)

        commandUserPort.saveUser(
            user.copy(
                friendCount = user.friendCount.dec()
            )
        )
    }
}