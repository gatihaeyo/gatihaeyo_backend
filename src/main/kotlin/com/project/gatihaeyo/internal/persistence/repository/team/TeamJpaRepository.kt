package com.project.gatihaeyo.internal.persistence.repository.team

import com.project.gatihaeyo.internal.persistence.model.team.TeamEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TeamJpaRepository : CrudRepository<TeamEntity, UUID> {

    fun queryTeamEntityById(id: UUID): TeamEntity?
}