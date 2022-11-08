package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.user.CommandAccountPort
import com.project.gatihaeyo.internal.application.port.OpenApiPort
import com.project.gatihaeyo.internal.domain.model.user.Account
import com.project.gatihaeyo.internal.domain.model.Category
import com.project.gatihaeyo.internal.dto.request.user.SavePUBGAccountRequest
import org.springframework.stereotype.Service

@Service
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
                type = Category.PUBG,
                name = request.name,
                accountKey = key
            )
        )
    }

}