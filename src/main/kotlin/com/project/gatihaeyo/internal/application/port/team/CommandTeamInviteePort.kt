package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.TeamInvitee
import java.util.UUID

interface CommandTeamInviteePort {

    fun saveTeamInvitee(teamInvitee: TeamInvitee): TeamInvitee

    fun deleteTeamInviteeByUserIdAndTeamId(userId: UUID, teamId: UUID)

    fun deleteTeamInviteeByTeamId(teamId: UUID)
}