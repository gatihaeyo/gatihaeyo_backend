package com.project.gatihaeyo.internal.message.model

import com.project.gatihaeyo.internal.BaseEntity
import com.project.gatihaeyo.internal.team.model.TeamEntity
import com.project.gatihaeyo.internal.user.model.UserEntity
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "tb_message")
class MessageEntity(
    override val id: UUID?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", columnDefinition = "BINARY(16)", nullable = false)
    val room: TeamEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user: UserEntity,

    val message: String

) : BaseEntity(id)