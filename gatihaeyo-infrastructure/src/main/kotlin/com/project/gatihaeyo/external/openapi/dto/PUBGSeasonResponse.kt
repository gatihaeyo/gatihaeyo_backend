package com.project.gatihaeyo.external.openapi.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PUBGSeasonResponse(
    val data: List<SeasonResponse>
) {
    data class SeasonResponse(
        val id: String,
        val attributes: AttributesResponse
    ) {
        data class AttributesResponse(
            @JsonProperty("isCurrentSeason")
            val isCurrentSeason: Boolean
        )
    }
}