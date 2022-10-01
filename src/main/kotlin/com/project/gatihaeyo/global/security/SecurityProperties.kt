package com.project.gatihaeyo.global.security

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.*

@ConfigurationPropertiesScan("spring.security")
@ConstructorBinding
class SecurityProperties(
    secretKey: String,
    accessExp: Int,
    refreshExp: Int
) {
    val accessExpiredTime = accessExp * 1000
    val refreshExpiredTime = refreshExp * 1000
    val encodingSecretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray())!!
}