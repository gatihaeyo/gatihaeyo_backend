package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.TeamApplicant

interface CommandTeamApplicantPort {

    fun saveTeamApplicant(teamApplicant: TeamApplicant): TeamApplicant
}