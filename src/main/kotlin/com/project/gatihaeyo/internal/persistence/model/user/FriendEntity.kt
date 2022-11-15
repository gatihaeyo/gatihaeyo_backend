package com.project.gatihaeyo.internal.persistence.model.user

import com.project.gatihaeyo.internal.persistence.model.BaseTimeEntity
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MapsId
import javax.persistence.Table

@Entity
@Table(name = "tb_friend")
class FriendEntity(
    @EmbeddedId
    val key: FriendEntityId,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user: UserEntity,

    @MapsId("friendId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id", columnDefinition = "BINARY(16)", nullable = false)
    val friend: UserEntity
) : BaseTimeEntity()