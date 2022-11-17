package com.project.gatihaeyo.internal.team.port

import com.project.gatihaeyo.internal.team.model.TeamDelay

interface CommandTeamDelayPort {

    fun saveTeamDelay(teamDelay: TeamDelay): TeamDelay
}