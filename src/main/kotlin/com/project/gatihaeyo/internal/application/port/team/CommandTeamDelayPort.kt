package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.TeamDelay

interface CommandTeamDelayPort {

    fun saveTeamDelay(teamDelay: TeamDelay): TeamDelay
}