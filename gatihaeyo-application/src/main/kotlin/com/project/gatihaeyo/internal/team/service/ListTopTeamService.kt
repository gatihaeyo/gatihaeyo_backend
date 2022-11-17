package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.exception.TeamListTopDelayException
import com.project.gatihaeyo.internal.team.exception.TeamNotFoundException
import com.project.gatihaeyo.internal.team.exception.TeamPermissionException
import com.project.gatihaeyo.internal.team.model.TeamDelay
import com.project.gatihaeyo.internal.team.port.CommandTeamDelayPort
import com.project.gatihaeyo.internal.team.port.CommandTeamPort
import com.project.gatihaeyo.internal.team.port.QueryTeamDelayPort
import com.project.gatihaeyo.internal.team.port.QueryTeamPort
import java.time.LocalDateTime
import java.util.UUID

@BusinessService
class ListTopTeamService(
    private val queryTeamPort: QueryTeamPort,
    private val queryTeamDelayPort: QueryTeamDelayPort,
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamDelayPort: CommandTeamDelayPort,
    private val securityPort: SecurityPort
) {

    fun execute(teamId: UUID) {
        val currentUserId = securityPort.getCurrentUserId()
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