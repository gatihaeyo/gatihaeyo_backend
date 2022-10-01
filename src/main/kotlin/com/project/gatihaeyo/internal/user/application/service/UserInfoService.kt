package com.project.gatihaeyo.internal.user.application.service

import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.user.application.port.QueryUserPort
import com.project.gatihaeyo.internal.user.domain.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.dto.response.UserInfoResponse
import org.springframework.stereotype.Service

@Service
class UserInfoService(
    private val queryUserPort: QueryUserPort,
    private val securityService: SecurityService
) {

    fun execute(): UserInfoResponse {
        val id = securityService.getCurrentUserId()

        val user = queryUserPort.queryUserById(id) ?: throw UserNotFoundException.EXCEPTION

        return UserInfoResponse(
            nickname = user.nickname,
            email = user.email,
            profileImagePath = user.profileImagePath
        )
    }

}