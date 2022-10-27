package com.project.gatihaeyo.internal.user.application.service

import com.project.gatihaeyo.external.openapi.client.LOLClient
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.external.openapi.OpenApiProperties
import com.project.gatihaeyo.internal.user.application.port.CommandAccountPort
import com.project.gatihaeyo.internal.user.application.port.OpenApiPort
import com.project.gatihaeyo.internal.user.domain.model.Account
import com.project.gatihaeyo.internal.user.domain.model.GameType
import com.project.gatihaeyo.internal.user.dto.request.SaveLOLAccountRequest
import org.springframework.stereotype.Service

@Service
class SaveLOLAccountService(
    private val securityService: SecurityService,
    private val commandGameAccountPort: CommandAccountPort,
    private val openApiPort: OpenApiPort
) {

    fun execute(request: SaveLOLAccountRequest) {
        val id = securityService.getCurrentUserId()

        val key = openApiPort.getLOLId(request.name)

        commandGameAccountPort.save(
            Account(
                userId = id,
                type = GameType.LOL,
                name = request.name,
                accountKey = key
            )
        )
    }

}