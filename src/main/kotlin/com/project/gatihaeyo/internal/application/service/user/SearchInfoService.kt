package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.internal.application.port.user.QueryAccountPort
import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.exception.user.UserNotFoundException
import com.project.gatihaeyo.internal.dto.response.user.UserInfoResponse
import org.springframework.stereotype.Service
import java.util.UUID

@Service
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