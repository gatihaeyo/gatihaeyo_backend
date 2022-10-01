package com.project.gatihaeyo.internal.auth.persistence.model

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import javax.validation.constraints.NotNull

@RedisHash("tb_authcode")
class AuthCodeEntity(
    @Id
    val email: String,

    @field:NotNull
    val code: String,

    @field:NotNull
    @TimeToLive
    val expirationTime: Int
)