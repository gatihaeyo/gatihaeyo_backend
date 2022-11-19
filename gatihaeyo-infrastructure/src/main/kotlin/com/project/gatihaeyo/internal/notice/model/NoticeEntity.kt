package com.project.gatihaeyo.internal.notice.model

import com.project.gatihaeyo.internal.BaseEntity
import com.project.gatihaeyo.internal.user.model.UserEntity
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "tb_notice")
class NoticeEntity(

    override val id: UUID?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user: UserEntity,

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    val content: String

) : BaseEntity(id)