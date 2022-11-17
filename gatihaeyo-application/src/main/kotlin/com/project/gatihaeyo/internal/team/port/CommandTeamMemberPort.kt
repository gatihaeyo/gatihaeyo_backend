package com.project.gatihaeyo.internal.team.port

import com.project.gatihaeyo.internal.team.model.TeamMember
import java.util.UUID

interface CommandTeamMemberPort {

    fun saveTeamMember(teamMember: TeamMember): TeamMember

    fun deleteTeamMemberByUserIdAndTeamId(userId: UUID, teamId: UUID)

    fun deleteTeamMemberByTeamId(teamId: UUID)
}