package com.project.gatihaeyo.internal.persistence.model.user

import com.project.gatihaeyo.internal.domain.model.Category
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
    val type: Category
) : Serializable