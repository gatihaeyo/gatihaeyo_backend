package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.TeamApplicant
import java.util.UUID

interface QueryTeamApplicantPort {

    fun queryTeamApplicantByUserIdAndTeamId(userId: UUID, teamId: UUID) : TeamApplicant?

    fun queryTeamApplicantListByUserId(userId: UUID): List<TeamApplicant>

    fun existsTeamApplicantByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean
}