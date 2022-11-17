package com.project.gatihaeyo.external.openapi.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PUBGRecordResponse(
    val data: DataResponse
) {
    data class DataResponse(
        val attributes: GameModeResponse
    ) {
        data class GameModeResponse(
            @JsonProperty("rankedGameModeStats")
            val rankedGameModeStats: RankedResponse
        ) {
            data class RankedResponse(
                val squad: PUBGScoreResponse?,
                val duo: PUBGScoreResponse?,
                val solo: PUBGScoreResponse?
            ) {
                data class PUBGScoreResponse(
                    @JsonProperty("currentTier")
                    val currentTier: PUBGTierResponse,

                    @JsonProperty("currentRankPoint")
                    val currentRankPoint: Int,

                    @JsonProperty("winRatio")
                    val winRatio: Double
                ) {
                     data class PUBGTierResponse(
                        val tier: String,

                        @JsonProperty("subTier")
                        val subTier: String
                    )
                }
            }
        }
    }
}