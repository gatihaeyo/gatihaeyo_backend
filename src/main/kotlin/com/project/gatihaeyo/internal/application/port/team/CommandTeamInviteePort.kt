package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.TeamInvitee

interface CommandTeamInviteePort {

    fun saveTeamInvitee(teamInvitee: TeamInvitee): TeamInvitee
}