package com.project.gatihaeyo.internal.team.port

import com.project.gatihaeyo.internal.team.model.Team
import java.util.UUID

interface CommandTeamPort {

    fun saveTeam(team: Team): Team

    fun deleteTeamById(teamId: UUID)

}