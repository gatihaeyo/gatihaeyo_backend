package com.project.gatihaeyo.internal.persistence.model.team

import com.project.gatihaeyo.internal.domain.model.Category
import com.project.gatihaeyo.internal.persistence.model.BaseEntity
import com.project.gatihaeyo.internal.persistence.model.user.UserEntity
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tb_team")
class TeamEntity(

    override val id: UUID?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val master: UserEntity,

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    val title: String,

    @field:NotNull
    @field:Enumerated(EnumType.STRING)
    val category: Category,

    @field:NotNull
    val personnel: Int,

    @field:NotNull
    val currentPersonnel: Int,

    @field:NotNull
    val applicantPersonnel: Int,

    @field:NotNull
    val updateAt: LocalDateTime

) : BaseEntity(id)