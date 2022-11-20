package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.team.Category
import com.project.gatihaeyo.internal.OpenApiPort
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.user.dto.SaveLOLAccountDto
import com.project.gatihaeyo.internal.user.model.Account
import com.project.gatihaeyo.internal.user.port.CommandAccountPort

@BusinessService
class SaveLOLAccountService(
    private val securityPort: SecurityPort,
    private val commandGameAccountPort: CommandAccountPort,
    private val openApiPort: OpenApiPort
) {

    fun execute(request: SaveLOLAccountDto) {
        val id = securityPort.getCurrentUserId()

        val key = openApiPort.getLOLId(request.name)

        commandGameAccountPort.save(
            Account(
                userId = id,
                type = Category.LEAGUEOFLEGEND,
                name = request.name,
                accountKey = key
            )
        )
    }

}