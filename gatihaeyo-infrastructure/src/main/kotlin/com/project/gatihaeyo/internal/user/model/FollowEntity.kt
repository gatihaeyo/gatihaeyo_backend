package com.project.gatihaeyo.internal.user.model

import com.project.gatihaeyo.internal.BaseTimeEntity
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MapsId
import javax.persistence.Table

@Entity
@Table(name = "tb_follow")
class FollowEntity(
    @EmbeddedId
    val key: FollowEntityId,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user: UserEntity,

    @MapsId("followId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follow_id", columnDefinition = "BINARY(16)", nullable = false)
    val follow: UserEntity
) : BaseTimeEntity()