package com.project.gatihaeyo.internal.persistence.model.team

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.UUID

@RedisHash("tb_team_delay")
data class TeamDelayEntity(
    @Id
    val teamId: UUID,

    @TimeToLive
    val delay: Int
)