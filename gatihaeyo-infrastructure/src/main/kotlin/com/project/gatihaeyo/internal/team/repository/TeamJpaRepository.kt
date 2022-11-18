package com.project.gatihaeyo.internal.team.repository

import com.project.gatihaeyo.internal.team.model.TeamEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TeamJpaRepository : CrudRepository<TeamEntity, UUID> {

    fun queryTeamEntityById(id: UUID): TeamEntity?
}