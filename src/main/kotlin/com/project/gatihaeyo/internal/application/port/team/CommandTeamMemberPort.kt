package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.TeamMember
import java.util.UUID

interface CommandTeamMemberPort {

    fun saveTeamMember(teamMember: TeamMember): TeamMember

    fun deleteTeamMemberByUserIdAndTeamId(userId: UUID, teamId: UUID)

    fun deleteTeamMemberByTeamId(teamId: UUID)
}