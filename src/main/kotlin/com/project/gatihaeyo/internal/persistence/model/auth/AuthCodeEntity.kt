package com.project.gatihaeyo.internal.persistence.model.auth

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import javax.validation.constraints.NotNull

@RedisHash("tb_authcode")
data class AuthCodeEntity(
    @Id
    var email: String,

    @field:NotNull
    var code: String,

    @field:NotNull
    @TimeToLive
    var expirationTime: Int
)