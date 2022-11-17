package com.project.gatihaeyo.internal.team.port

import com.project.gatihaeyo.internal.team.model.TeamMember
import java.util.UUID

interface QueryTeamMemberPort {

    fun queryTeamMemberByUserId(userId: UUID): TeamMember?

    fun queryTeamMemberListByTeamId(teamId: UUID): List<TeamMember>

    fun existsTeamMemberByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean
}