package com.project.gatihaeyo.external.openapi.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class LOLRecordResponse(
    @JsonProperty("leaguePoints")
    val leaguePoints: Int,

    val tier: String,
    val rank: String,
    val wins: Int,
    val losses: Int
)