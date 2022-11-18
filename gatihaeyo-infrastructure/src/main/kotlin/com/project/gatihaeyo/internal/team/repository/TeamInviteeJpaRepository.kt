package com.project.gatihaeyo.internal.team.repository

import com.project.gatihaeyo.internal.team.model.TeamInviteeEntity
import com.project.gatihaeyo.internal.team.model.TeamUserEntityId
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TeamInviteeJpaRepository : CrudRepository<TeamInviteeEntity, TeamUserEntityId> {

    fun queryTeamInviteeEntitiesByUserId(userId: UUID): List<TeamInviteeEntity>

    fun deleteTeamInviteeEntitiesByTeamId(teamId: UUID)

}