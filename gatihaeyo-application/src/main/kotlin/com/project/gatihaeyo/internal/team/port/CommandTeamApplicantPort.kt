package com.project.gatihaeyo.internal.team.port

import com.project.gatihaeyo.internal.team.model.TeamApplicant
import java.util.UUID

interface CommandTeamApplicantPort {

    fun saveTeamApplicant(teamApplicant: TeamApplicant): TeamApplicant

    fun deleteTeamApplicantByTeamId(teamId: UUID)

    fun deleteTeamApplicantByUserIdAndTeamId(userId: UUID, teamId: UUID)
}