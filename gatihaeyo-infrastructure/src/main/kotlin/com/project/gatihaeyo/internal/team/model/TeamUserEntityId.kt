package com.project.gatihaeyo.internal.team.model

import java.io.Serializable
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class TeamUserEntityId(

    @Column
    val userId: UUID,
    val teamId: UUID

) : Serializable