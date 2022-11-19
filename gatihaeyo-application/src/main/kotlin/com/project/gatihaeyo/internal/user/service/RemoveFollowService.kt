package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.user.exception.FollowNotFoundException
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.port.CommandFollowPort
import com.project.gatihaeyo.internal.user.port.CommandUserPort
import com.project.gatihaeyo.internal.user.port.QueryFollowPort
import com.project.gatihaeyo.internal.user.port.QueryUserPort
import java.util.UUID

@BusinessService
class RemoveFollowService(
    private val queryFollowPort: QueryFollowPort,
    private val queryUserPort: QueryUserPort,
    private val commandFollowPort: CommandFollowPort,
    private val commandUserPort: CommandUserPort,
    private val securityPort: SecurityPort
) {

    fun execute(followId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()

        val user = queryUserPort.queryUserById(followId) ?: throw UserNotFoundException.EXCEPTION

        if (!queryFollowPort.existsFollowByUserIdAndFollowId(currentUserId, followId)) {
            throw FollowNotFoundException.EXCEPTION
        }

        commandFollowPort.deleteFollowByUserIdAndFollowId(currentUserId, followId)

        commandUserPort.saveUser(
            user.copy(
                followCount = user.followCount.dec()
            )
        )
    }
}