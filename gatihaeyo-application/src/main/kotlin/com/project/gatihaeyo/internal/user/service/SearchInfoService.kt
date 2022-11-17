package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.user.dto.response.UserInfoResponse
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.port.QueryAccountPort
import com.project.gatihaeyo.internal.user.port.QueryUserPort
import java.util.UUID

@ReadOnlyBusinessService
class SearchInfoService(
    private val queryUserPort: QueryUserPort,
    private val queryAccountPort: QueryAccountPort
) {

    fun execute(id: UUID) : UserInfoResponse {
        val user = queryUserPort.queryUserById(id) ?: throw UserNotFoundException.EXCEPTION

        val account = queryAccountPort.queryAccountByUserId(id)
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
            accounts = account
        )
    }
}