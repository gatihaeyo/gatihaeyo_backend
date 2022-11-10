package com.project.gatihaeyo.internal.persistence.model.team

import com.project.gatihaeyo.internal.persistence.model.BaseTimeEntity
import com.project.gatihaeyo.internal.persistence.model.user.UserEntity
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MapsId
import javax.persistence.Table

@Entity
@Table(name = "tb_team_invitee")
class TeamInviteeEntity(

    @EmbeddedId
    val key: TeamUserEntityId,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")
    val user: UserEntity,

    @MapsId("teamId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", columnDefinition = "BINARY(16)")
    val team: TeamEntity

) : BaseTimeEntity()