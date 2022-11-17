package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.user.dto.response.UserResponse
import com.project.gatihaeyo.internal.user.port.QueryUserPort

@ReadOnlyBusinessService
class SearchUserService(
    private val queryUserPort: QueryUserPort
) {

    fun execute(keyword: String): List<UserResponse> {
        return queryUserPort.queryUserListByNickname(keyword).map {
            UserResponse(
                id = it.id,
                nickname = it.nickname,
                email = it.email,
                profileImagePath = it.profileImagePath
            )
        }
    }
}