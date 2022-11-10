package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.CommandTeamDelayPort
import com.project.gatihaeyo.internal.application.port.team.CommandTeamPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamDelayPort
import com.project.gatihaeyo.internal.application.port.team.QueryTeamPort
import com.project.gatihaeyo.internal.domain.exception.team.TeamListTopDelayException
import com.project.gatihaeyo.internal.domain.exception.team.TeamNotFoundException
import com.project.gatihaeyo.internal.domain.exception.team.TeamPermissionException
import com.project.gatihaeyo.internal.domain.model.team.TeamDelay
import java.time.LocalDateTime
import java.util.UUID

@BusinessService
class ListTopTeamService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamDelayPort: QueryTeamDelayPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamDelayPort: CommandTeamDelayPort,
    private val securityService: SecurityService
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityService.getCurrentUserId()
        val team = queryTeamPort.queryTeamById(teamId) ?: throw TeamNotFoundException.EXCEPTION

        if (team.master != currentUserId) {
            throw TeamPermissionException.EXCEPTION
        }

        if (queryTeamDelayPort.existsTeamDelayByTeamId(teamId)) {
            throw TeamListTopDelayException.EXCEPTION
        }

        commandTeamDelayPort.saveTeamDelay(
            TeamDelay(teamId)
        )

        commandTeamPort.saveTeam(
            team.copy(
                updateAt = LocalDateTime.now()
            )
        )

    }

}