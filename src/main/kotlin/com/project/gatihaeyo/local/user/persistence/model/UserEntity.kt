package com.project.gatihaeyo.local.user.persistence.model

import com.project.gatihaeyo.global.BaseEntity
import com.project.gatihaeyo.local.user.domain.model.Authority
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
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

    @field:NotNull
    @Enumerated(EnumType.STRING)
    val authority: Authority,

    val profileImagePath: String,

    val suspendAt: LocalDateTime?
) : BaseEntity(id)