package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.team.Team
import java.util.UUID

interface QueryTeamPort {

    fun queryTeamById(id: UUID) : Team?
}