package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.Category
import com.project.gatihaeyo.internal.OpenApiPort
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.user.dto.SavePUBGAccountDto
import com.project.gatihaeyo.internal.user.model.Account
import com.project.gatihaeyo.internal.user.port.CommandAccountPort

@BusinessService
class SavePUBGAccountService(
    private val securityPort: SecurityPort,
    private val commandGameAccountPort: CommandAccountPort,
    private val openApiPort: OpenApiPort
) {

    fun execute(request: SavePUBGAccountDto) {
        val id = securityPort.getCurrentUserId()

        val key = openApiPort.getPUBGId(request.name)

        commandGameAccountPort.save(
            Account(
                userId = id,
                type = Category.BATTELGROUND,
                name = request.name,
                accountKey = key
            )
        )
    }

}