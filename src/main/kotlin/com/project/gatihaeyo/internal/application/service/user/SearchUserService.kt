package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.model.user.User

@ReadOnlyBusinessService
class SearchUserService(
    private val queryUserPort: QueryUserPort
) {

    fun execute(keyword: String): List<User> {
        return queryUserPort.queryUserListByNickname(keyword)
    }
}