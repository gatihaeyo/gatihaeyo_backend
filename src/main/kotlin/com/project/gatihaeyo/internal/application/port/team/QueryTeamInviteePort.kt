package com.project.gatihaeyo.internal.application.port.team

import java.util.UUID

interface QueryTeamInviteePort {

    fun existsTeamInviteeByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean
}