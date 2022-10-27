package com.project.gatihaeyo.internal.user.persistence.model

import com.project.gatihaeyo.internal.user.domain.model.GameType
import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

@Embeddable
class AccountEntityId(
    @ManyToOne
    @JoinColumn(name = "userId", columnDefinition = "BINARY(16)", nullable = false)
    val user: UserEntity,

    @Enumerated(EnumType.STRING)
    @field:NotNull
    val type: GameType
) : Serializable