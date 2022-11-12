package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.Team
import java.util.UUID

interface CommandTeamPort {

    fun saveTeam(team: Team): Team

    fun deleteTeamById(teamId: UUID)

}