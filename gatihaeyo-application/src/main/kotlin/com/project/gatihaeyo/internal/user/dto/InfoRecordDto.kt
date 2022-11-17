package com.project.gatihaeyo.internal.user.dto

data class InfoRecordDto(
    val type: String? = null,
    val tier: String,
    val rank: String,
    val point: Int,
    val winRatio: Double
)