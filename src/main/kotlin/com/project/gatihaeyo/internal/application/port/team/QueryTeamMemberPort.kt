package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.TeamMember
import java.util.UUID

interface QueryTeamMemberPort {

    fun queryTeamMemberByUserId(userId: UUID): TeamMember?

    fun existsTeamMemberByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean
}