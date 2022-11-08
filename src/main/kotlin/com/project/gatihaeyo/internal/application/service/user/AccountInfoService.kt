package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.external.openapi.dto.InfoRecordDto
import com.project.gatihaeyo.global.exception.InternalServerErrorException
import com.project.gatihaeyo.internal.application.port.OpenApiPort
import com.project.gatihaeyo.internal.application.port.user.QueryAccountPort
import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.exception.user.AccountNotFoundException
import com.project.gatihaeyo.internal.domain.exception.user.UserNotFoundException
import com.project.gatihaeyo.internal.domain.model.Category
import com.project.gatihaeyo.internal.dto.request.user.AccountInfoRequest
import org.springframework.stereotype.Service

@Service
class AccountInfoService(
    private val openApiPort: OpenApiPort,
    private val queryUserPort: QueryUserPort,
    private val queryAccountPort: QueryAccountPort
) {

    fun execute(request: AccountInfoRequest): List<InfoRecordDto> {
        val user = queryUserPort.queryUserByNickname(request.nickname)
            ?: throw UserNotFoundException.EXCEPTION

        val account = queryAccountPort.queryAccountByAccountId(
            user = user,
            type = request.type
        ) ?: throw AccountNotFoundException.EXCEPTION

        return when (account.type) {
            Category.LOL -> openApiPort.getLOLInfo(account.accountKey)
            Category.PUBG -> openApiPort.getPUBGInfo(account.accountKey)
            else -> throw InternalServerErrorException.EXCEPTION
        }
    }

}