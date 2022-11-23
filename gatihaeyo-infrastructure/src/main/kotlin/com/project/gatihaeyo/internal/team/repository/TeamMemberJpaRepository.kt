package com.project.gatihaeyo.internal.team.repository

import com.project.gatihaeyo.internal.team.model.TeamMemberEntity
import com.project.gatihaeyo.internal.team.model.TeamUserEntityId
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TeamMemberJpaRepository : CrudRepository<TeamMemberEntity, TeamUserEntityId> {

    fun existsTeamMemberEntityByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean

    fun deleteTeamMemberEntityByUserIdAndTeamId(userId: UUID, teamId: UUID)

    fun deleteTeamMemberEntitiesByTeamId(teamId: UUID)
}