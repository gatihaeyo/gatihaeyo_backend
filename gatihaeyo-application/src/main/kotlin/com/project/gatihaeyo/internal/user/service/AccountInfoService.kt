package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.Category
import com.project.gatihaeyo.internal.OpenApiPort
import com.project.gatihaeyo.internal.user.dto.AccountInfoDto
import com.project.gatihaeyo.internal.user.dto.InfoRecordDto
import com.project.gatihaeyo.internal.user.exception.AccountNotFoundException
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.port.QueryAccountPort
import com.project.gatihaeyo.internal.user.port.QueryUserPort

@ReadOnlyBusinessService
class AccountInfoService(
    private val openApiPort: OpenApiPort,
    private val queryUserPort: QueryUserPort,
    private val queryAccountPort: QueryAccountPort
) {

    fun execute(request: AccountInfoDto): List<InfoRecordDto> {
        val user = queryUserPort.queryUserByNickname(request.nickname)
            ?: throw UserNotFoundException.EXCEPTION

        val account = queryAccountPort.queryAccountByAccountId(
            user = user,
            type = request.type.value
        ) ?: throw AccountNotFoundException.EXCEPTION

        return when (account.type) {
            Category.LEAGUEOFLEGEND -> openApiPort.getLOLInfo(account.accountKey)
            Category.BATTELGROUND -> openApiPort.getPUBGInfo(account.accountKey)
            else -> listOf()
        }
    }

}