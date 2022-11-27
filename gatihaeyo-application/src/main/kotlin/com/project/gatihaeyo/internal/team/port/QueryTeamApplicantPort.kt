package com.project.gatihaeyo.internal.team.port

import com.project.gatihaeyo.internal.team.model.TeamApplicant
import java.util.UUID

interface QueryTeamApplicantPort {

    fun queryTeamApplicantByUserIdAndTeamId(userId: UUID, teamId: UUID) : TeamApplicant?

    fun queryTeamApplicantByTeamId(teamId: UUID): List<TeamApplicant>

    fun queryTeamApplicantListByUserId(userId: UUID): List<TeamApplicant>

    fun existsTeamApplicantByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean
}