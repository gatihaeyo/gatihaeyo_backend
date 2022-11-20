package com.project.gatihaeyo.internal.team.port

import com.project.gatihaeyo.internal.team.Category
import com.project.gatihaeyo.internal.team.Order
import com.project.gatihaeyo.internal.team.model.Team
import java.util.UUID

interface QueryTeamPort {

    fun queryTeamById(id: UUID) : Team?

    fun existsTeamById(id: UUID) : Boolean

    fun queryTeamList(size: Int, page: Long, order: Order, category: Category): List<Team>
}