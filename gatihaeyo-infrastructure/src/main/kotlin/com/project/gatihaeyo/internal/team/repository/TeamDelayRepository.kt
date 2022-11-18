package com.project.gatihaeyo.internal.team.repository

import com.project.gatihaeyo.internal.team.model.TeamDelayEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TeamDelayRepository : CrudRepository<TeamDelayEntity, UUID> {
}