package com.project.gatihaeyo.external.openapi.dto

data class PUBGIdResponse(
    val data: List<PUBGDataResponse>
) {
    data class PUBGDataResponse(
        val id: String
    )
}