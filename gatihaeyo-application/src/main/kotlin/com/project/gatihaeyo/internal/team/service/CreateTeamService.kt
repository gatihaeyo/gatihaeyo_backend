package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.dto.CreateTeamDto
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamResponse
import com.project.gatihaeyo.internal.team.model.Team
import com.project.gatihaeyo.internal.team.model.TeamMember
import com.project.gatihaeyo.internal.team.port.CommandTeamMemberPort
import com.project.gatihaeyo.internal.team.port.CommandTeamPort

@BusinessService
class CreateTeamService(
    private val commandTeamPort: CommandTeamPort,
    private val commandTeamMemberPort: CommandTeamMemberPort,
    private val securityPort: SecurityPort
) {

    fun execute(request: CreateTeamDto) : ShowTeamResponse {
        val (title, content, category, personnel) = request
        val currentUserId = securityPort.getCurrentUserId()

        val team = commandTeamPort.saveTeam(
            Team(
                master = currentUserId,
                title = title,
                content = content,
                category = category.value,
                personnel = personnel
            )
        )

        commandTeamMemberPort.saveTeamMember(
            TeamMember(
                userId = currentUserId,
                teamId = team.id
            )
        )

        return ShowTeamResponse(
            id = team.id,
            master = team.master,
            title = team.title,
            content = team.content,
            category = team.category,
            personnel = team.personnel,
            currentPersonnel = team.currentPersonnel,
            applicantPersonnel = team.applicantPersonnel,
            updateAt = team.updateAt
        )
    }

}