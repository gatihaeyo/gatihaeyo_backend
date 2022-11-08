package com.project.gatihaeyo.internal.persistence.model.auth

import com.project.gatihaeyo.internal.domain.model.user.Authority
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.UUID
import javax.validation.constraints.NotNull

@RedisHash("tb_token")
data class RefreshTokenEntity(
    @Id
    val token: String,

    @field:NotNull
    val userId: UUID,

    @field:NotNull
    val authority: Authority,

    @field:NotNull
    @TimeToLive
    val expirationTime: Int
)