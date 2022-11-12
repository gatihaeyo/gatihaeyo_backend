package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.TeamApplicant
import java.util.UUID

interface CommandTeamApplicantPort {

    fun saveTeamApplicant(teamApplicant: TeamApplicant): TeamApplicant

    fun deleteTeamApplicantByTeamId(teamId: UUID)
}