package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.notice.model.Notice
import com.project.gatihaeyo.internal.notice.port.CommandNoticePort
import com.project.gatihaeyo.internal.user.exception.AlreadyFriendException
import com.project.gatihaeyo.internal.user.exception.CannotFollowAloneException
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.model.Follow
import com.project.gatihaeyo.internal.user.port.CommandFollowPort
import com.project.gatihaeyo.internal.user.port.CommandUserPort
import com.project.gatihaeyo.internal.user.port.QueryFollowPort
import com.project.gatihaeyo.internal.user.port.QueryUserPort
import java.util.UUID

@BusinessService
class AppendFollowService(
    private val queryUserPort: QueryUserPort,
    private val queryFollowPort: QueryFollowPort,
    private val commandUserPort: CommandUserPort,
    private val commandFollowPort: CommandFollowPort,
    private val commandNoticePort: CommandNoticePort,
    private val securityPort: SecurityPort
) {

    fun execute(followId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()

        val user = queryUserPort.queryUserById(followId) ?: throw UserNotFoundException.EXCEPTION

        when {
            currentUserId == followId -> throw CannotFollowAloneException.EXCEPTION

            !queryFollowPort.existsFollowByUserIdAndFollowId(currentUserId, followId)
                -> throw AlreadyFriendException.EXCEPTION
        }

        commandFollowPort.saveFollow(
            Follow(
                userId = currentUserId,
                followId = followId
            )
        )

        commandUserPort.saveUser(
            user.copy(
                followCount = user.followCount.inc()
            )
        )

        commandNoticePort.saveNotice(
            Notice(
                userId = followId,
                content = Notice.followMessage(user.nickname),
            )
        )
    }
}