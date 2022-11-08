package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.Team

interface CommandTeamPort {

    fun saveTeam(team: Team): Team

}