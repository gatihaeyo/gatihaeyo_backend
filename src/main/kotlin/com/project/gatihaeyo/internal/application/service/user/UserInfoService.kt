package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.user.QueryAccountPort
import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.exception.user.UserNotFoundException
import com.project.gatihaeyo.internal.dto.response.user.UserInfoResponse
import java.util.UUID

@ReadOnlyBusinessService
class UserInfoService(
    private val queryUserPort: QueryUserPort,
    private val queryAccountPort: QueryAccountPort,
    private val securityService: SecurityService
) {

    fun execute(userId: UUID?): UserInfoResponse {
        val id = userId ?: securityService.getCurrentUserId()

        val user = queryUserPort.queryUserById(id) ?: throw UserNotFoundException.EXCEPTION

        val accounts = queryAccountPort.queryAccountByUserId(id)
            .map {
                UserInfoResponse.AccountInfoResponse(
                    name = it.name,
                    type = it.type
                )
            }

        return UserInfoResponse(
            id = user.id,
            nickname = user.nickname,
            email = user.email,
            profileImagePath = user.profileImagePath,
            accounts = accounts
        )
    }

}