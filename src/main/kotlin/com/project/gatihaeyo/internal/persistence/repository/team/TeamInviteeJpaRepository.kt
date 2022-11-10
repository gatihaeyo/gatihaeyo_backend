package com.project.gatihaeyo.internal.persistence.repository.team

import com.project.gatihaeyo.internal.persistence.model.team.TeamInviteeEntity
import com.project.gatihaeyo.internal.persistence.model.team.TeamUserEntityId
import org.springframework.data.repository.CrudRepository

interface TeamInviteeJpaRepository : CrudRepository<TeamInviteeEntity, TeamUserEntityId> {

    fun deleteTeamInviteeEntityByKey(key: TeamUserEntityId)

}