package com.project.gatihaeyo.internal.user.model

import java.io.Serializable
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class FollowEntityId(
    @Column
    val userId: UUID,
    val followId: UUID

) : Serializable