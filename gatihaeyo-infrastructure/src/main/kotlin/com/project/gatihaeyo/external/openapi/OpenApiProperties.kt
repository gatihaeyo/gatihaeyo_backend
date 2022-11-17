package com.project.gatihaeyo.external.openapi

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("open-api")
@ConstructorBinding
class OpenApiProperties(
    val leagueOfLegend: String,
    battleGround: String
) {
    val pubg = "Bearer $battleGround"
}