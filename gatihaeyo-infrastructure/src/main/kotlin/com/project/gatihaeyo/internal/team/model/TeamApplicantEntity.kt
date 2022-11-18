package com.project.gatihaeyo.internal.team.model

import com.project.gatihaeyo.internal.BaseTimeEntity
import com.project.gatihaeyo.internal.user.model.UserEntity
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MapsId
import javax.persistence.Table

@Entity
@Table(name = "tb_team_applicant")
class TeamApplicantEntity(

    @EmbeddedId
    val key: TeamUserEntityId,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user: UserEntity,

    @MapsId("teamId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", columnDefinition = "BINARY(16)", nullable = false)
    val team: TeamEntity

) : BaseTimeEntity()