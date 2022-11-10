package com.project.gatihaeyo.internal.application.port.team

import java.util.UUID

interface QueryTeamDelayPort {

    fun existsTeamDelayByTeamId(teamId: UUID): Boolean
}