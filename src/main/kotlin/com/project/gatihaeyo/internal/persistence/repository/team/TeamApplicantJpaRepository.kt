package com.project.gatihaeyo.internal.persistence.repository.team

import com.project.gatihaeyo.internal.persistence.model.team.TeamApplicantEntity
import com.project.gatihaeyo.internal.persistence.model.team.TeamUserEntityId
import org.springframework.data.repository.CrudRepository

interface TeamApplicantJpaRepository : CrudRepository<TeamApplicantEntity, TeamUserEntityId> {

    fun queryTeamApplicantEntityByKey(key: TeamUserEntityId): TeamApplicantEntity?

}