package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.CommandTeamMemberPort
import com.project.gatihaeyo.internal.application.port.team.CommandTeamPort
import com.project.gatihaeyo.internal.domain.model.team.Team
import com.project.gatihaeyo.internal.domain.model.team.TeamMember
import com.project.gatihaeyo.internal.dto.request.team.CreateTeamRequest
import org.springframework.stereotype.Service

@Service
class CreateTeamService(
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val securityService: SecurityService
) {

    fun execute(request: CreateTeamRequest) {
        val currentUserId = securityService.getCurrentUserId()

        val team = commandTeamPort.saveTeam(
            Team(
                master = currentUserId,
                title = request.title,
                category = request.category,
                personnel = request.personnel
            )
        )

        commandTeamMemberPort.saveTeamMember(
            TeamMember(
                userId = currentUserId,
                teamId = team.id
            )
        )
    }

}