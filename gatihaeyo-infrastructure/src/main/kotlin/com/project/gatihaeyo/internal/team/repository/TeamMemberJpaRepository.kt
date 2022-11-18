package com.project.gatihaeyo.internal.team.repository

import com.project.gatihaeyo.internal.team.model.TeamMemberEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TeamMemberJpaRepository : CrudRepository<TeamMemberEntity, UUID> {

    fun queryTeamMemberEntityByUserId(userId: UUID): TeamMemberEntity?

    fun queryTeamMemberEntitiesByTeamId(teamId: UUID): List<TeamMemberEntity>

    fun existsTeamMemberEntityByUserIdAndTeamId(userId: UUID, teamId: UUID): Boolean

    fun deleteTeamMemberEntityByUserIdAndTeamId(userId: UUID, teamId: UUID)

    fun deleteTeamMemberEntitiesByTeamId(teamId: UUID)
}