package com.project.gatihaeyo.internal.team.port

import com.project.gatihaeyo.internal.team.model.TeamInvitee
import java.util.UUID

interface QueryTeamInviteePort {

    fun existsTeamInviteeByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean

    fun queryTeamInviteesByUserId(userId: UUID): List<TeamInvitee>
}