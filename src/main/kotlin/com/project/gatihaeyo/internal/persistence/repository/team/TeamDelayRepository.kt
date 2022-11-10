package com.project.gatihaeyo.internal.persistence.repository.team

import com.project.gatihaeyo.internal.persistence.model.team.TeamDelayEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TeamDelayRepository : CrudRepository<TeamDelayEntity, UUID> {
}