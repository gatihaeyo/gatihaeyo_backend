package com.project.gatihaeyo.internal.user.application.service

import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.user.application.port.CommandAccountPort
import com.project.gatihaeyo.internal.user.application.port.OpenApiPort
import com.project.gatihaeyo.internal.user.domain.model.Account
import com.project.gatihaeyo.internal.user.domain.model.GameType
import com.project.gatihaeyo.internal.user.dto.request.SavePUBGAccountRequest
import org.springframework.stereotype.Component

@Component
class SavePUBGAccountService(
    private val securityService: SecurityService,
    private val commandGameAccountPort: CommandAccountPort,
    private val openApiPort: OpenApiPort
) {

    fun execute(request: SavePUBGAccountRequest) {
        val id = securityService.getCurrentUserId()

        val key = openApiPort.getPUBGId(request.name)

        commandGameAccountPort.save(
            Account(
                userId = id,
                type = GameType.PUBG,
                name = request.name,
                accountKey = key
            )
        )
    }

}