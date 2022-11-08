package com.project.gatihaeyo.internal.persistence.repository.team

import com.project.gatihaeyo.internal.persistence.model.team.TeamMemberEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TeamMemberJpaRepository : CrudRepository<TeamMemberEntity, UUID> {

    fun queryTeamMemberEntityByUserId(userId: UUID): TeamMemberEntity?

    fun existsTeamMemberEntityByUserId(userId: UUID): Boolean
}