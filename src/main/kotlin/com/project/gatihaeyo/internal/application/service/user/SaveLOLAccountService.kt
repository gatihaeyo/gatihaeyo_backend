package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.user.CommandAccountPort
import com.project.gatihaeyo.internal.application.port.OpenApiPort
import com.project.gatihaeyo.internal.domain.model.user.Account
import com.project.gatihaeyo.internal.domain.model.Category
import com.project.gatihaeyo.internal.dto.request.user.SaveLOLAccountRequest
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
                type = Category.LOL,
                name = request.name,
                accountKey = key
            )
        )
    }

}