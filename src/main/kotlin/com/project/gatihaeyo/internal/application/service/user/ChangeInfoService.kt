package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.user.CommandUserPort
import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.exception.user.UserNotFoundException
import com.project.gatihaeyo.internal.dto.request.user.ChangeInfoRequest

@BusinessService
class ChangeInfoService(
    private val queryUserPort: QueryUserPort,
    private val commandUserPort: CommandUserPort,
    private val securityService: SecurityService
) {

    fun execute(request: ChangeInfoRequest) {
        val id = securityService.getCurrentUserId()
        val user = queryUserPort.queryUserById(id) ?: throw UserNotFoundException.EXCEPTION

        commandUserPort.save(
            user.copy(
                nickname = request.nickname ?: user.nickname,
                profileImagePath = request.profileImagePath ?: user.profileImagePath
            )
        )
    }

}