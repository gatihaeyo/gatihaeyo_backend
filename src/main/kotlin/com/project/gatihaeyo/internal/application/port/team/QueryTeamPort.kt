package com.project.gatihaeyo.internal.application.port.team

import com.project.gatihaeyo.internal.domain.model.Category
import com.project.gatihaeyo.internal.domain.model.Order
import com.project.gatihaeyo.internal.domain.model.team.Team
import java.time.LocalDateTime
import java.util.UUID

interface QueryTeamPort {

    fun queryTeamById(id: UUID) : Team?

    fun existsTeamById(id: UUID) : Boolean

    fun queryTeamList(size: Int, last: LocalDateTime, order: Order, category: Category): List<Team>
}