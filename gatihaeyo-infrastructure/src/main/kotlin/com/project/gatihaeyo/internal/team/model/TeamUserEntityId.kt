package com.project.gatihaeyo.internal.team.model

import java.io.Serializable
import java.util.UUID

data class TeamUserEntityId(

    val userId: UUID,
    val teamId: UUID

) : Serializable