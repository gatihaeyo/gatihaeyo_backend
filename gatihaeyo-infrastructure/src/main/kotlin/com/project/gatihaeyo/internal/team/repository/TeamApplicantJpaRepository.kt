package com.project.gatihaeyo.internal.team.repository

import com.project.gatihaeyo.internal.team.model.TeamApplicantEntity
import com.project.gatihaeyo.internal.team.model.TeamUserEntityId
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TeamApplicantJpaRepository : CrudRepository<TeamApplicantEntity, TeamUserEntityId> {

    fun queryTeamApplicantEntityByKey(key: TeamUserEntityId): TeamApplicantEntity?

    fun queryTeamApplicantEntitiesByUserId(userId: UUID): List<TeamApplicantEntity>

    fun queryTeamApplicantEntitiesByTeamId(teamID: UUID): List<TeamApplicantEntity>

    fun deleteTeamApplicantEntitiesByTeamId(teamId: UUID)

}