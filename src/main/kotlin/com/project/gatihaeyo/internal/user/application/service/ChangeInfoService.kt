package com.project.gatihaeyo.internal.user.application.service

import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.user.application.port.CommandUserPort
import com.project.gatihaeyo.internal.user.application.port.QueryUserPort
import com.project.gatihaeyo.internal.user.domain.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.dto.request.ChangeInfoRequest
import org.springframework.stereotype.Service

@Service
class ChangeInfoService(
    private val queryUserPort: QueryUserPort,
    private val commandUserPort: CommandUserPort,
    private val securityService: SecurityService
) {

    fun execute(request: ChangeInfoRequest) {
        val id = securityService.getCurrentUserId()
        val user = queryUserPort.queryUserById(id) ?: throw UserNotFoundException.EXCEPTION

        commandUserPort.save(
            user.updateInfo(request.nickname, request.profileImagePath)
        )
    }

}