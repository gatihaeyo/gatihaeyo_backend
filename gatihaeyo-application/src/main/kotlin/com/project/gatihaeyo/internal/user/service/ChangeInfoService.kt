package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.user.dto.ChangeInfoDto
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.port.CommandUserPort
import com.project.gatihaeyo.internal.user.port.QueryUserPort

@BusinessService
class ChangeInfoService(
    private val queryUserPort: QueryUserPort,
    private val commandUserPort: CommandUserPort,
    private val securityPort: SecurityPort
) {

    fun execute(request: ChangeInfoDto) {
        val currentUserId = securityPort.getCurrentUserId()
        val user = queryUserPort.queryUserById(currentUserId) ?: throw UserNotFoundException.EXCEPTION

        commandUserPort.saveUser(
            user.copy(
                nickname = request.nickname,
                profileImagePath = request.profileImagePath ?: user.profileImagePath
            )
        )
    }

}