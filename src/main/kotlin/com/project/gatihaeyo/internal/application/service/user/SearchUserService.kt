package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.model.user.User
import org.springframework.stereotype.Service

@Service
class SearchUserService(
    private val queryUserPort: QueryUserPort
) {

    fun execute(keyword: String): List<User> {
        return queryUserPort.queryUserListByNickname(keyword)
    }
}