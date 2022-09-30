package com.project.gatihaeyo.local.user.persistence.model

import com.project.gatihaeyo.global.BaseEntity
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tb_user")
class UserEntity(
    override val id: UUID?,

    @field:NotNull
    @field:Length(max = 16)
    @Column(unique = true)
    val nickname: String,

    @field:NotNull
    @Column(unique = true)
    val email: String,

    @field:NotNull
    @Column(columnDefinition = "CHAR(60)")
    val password: String,

    val suspendAt: LocalDateTime?
) : BaseEntity(id)