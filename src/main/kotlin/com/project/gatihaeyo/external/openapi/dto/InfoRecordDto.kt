package com.project.gatihaeyo.external.openapi.dto

data class InfoRecordDto(
    val type: String? = null,
    val tier: String,
    val rank: String,
    val point: Int,
    val winRatio: Double
)