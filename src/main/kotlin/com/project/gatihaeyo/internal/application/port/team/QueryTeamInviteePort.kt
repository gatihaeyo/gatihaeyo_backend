package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.TeamInvitee
import java.util.UUID

interface QueryTeamInviteePort {

    fun existsTeamInviteeByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean

    fun queryTeamInviteesByUserId(userId: UUID): List<TeamInvitee>
}