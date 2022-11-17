package com.project.gatihaeyo.internal.team.port

import com.project.gatihaeyo.internal.team.model.TeamInvitee
import java.util.UUID

interface CommandTeamInviteePort {

    fun saveTeamInvitee(teamInvitee: TeamInvitee): TeamInvitee

    fun deleteTeamInviteeByUserIdAndTeamId(userId: UUID, teamId: UUID)

    fun deleteTeamInviteeByTeamId(teamId: UUID)
}