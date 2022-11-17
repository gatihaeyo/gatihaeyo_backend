package com.project.gatihaeyo.internal.team.port

import java.util.UUID

interface QueryTeamDelayPort {

    fun existsTeamDelayByTeamId(teamId: UUID): Boolean
}