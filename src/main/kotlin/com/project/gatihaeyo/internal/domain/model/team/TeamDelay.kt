package com.project.gatihaeyo.internal.domain.model.team

import com.project.gatihaeyo.global.annotation.Default
import java.lang.System.getenv
import java.util.UUID

data class TeamDelay @Default constructor(
    val teamId: UUID,
    val delay: Int
) {

    constructor(teamId: UUID) : this(
        teamId = teamId,
        delay = DELAY_TIME
    )

    companion object {
        @JvmField
        val DELAY_TIME = getenv("TEAM_DELAY_TIME").toInt()
    }

}