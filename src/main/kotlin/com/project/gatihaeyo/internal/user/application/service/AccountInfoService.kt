package com.project.gatihaeyo.internal.user.application.service

import com.project.gatihaeyo.external.openapi.dto.InfoRecordDto
import com.project.gatihaeyo.global.exception.InternalServerErrorException
import com.project.gatihaeyo.internal.user.application.port.OpenApiPort
import com.project.gatihaeyo.internal.user.application.port.QueryAccountPort
import com.project.gatihaeyo.internal.user.application.port.QueryUserPort
import com.project.gatihaeyo.internal.user.domain.exception.AccountNotFoundException
import com.project.gatihaeyo.internal.user.domain.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.domain.model.GameType
import com.project.gatihaeyo.internal.user.dto.request.AccountInfoRequest
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
            GameType.LOL -> openApiPort.getLOLInfo(account.accountKey)
            GameType.PUBG -> openApiPort.getPUBGInfo(account.accountKey)
            else -> throw InternalServerErrorException.EXCEPTION
        }
    }

}