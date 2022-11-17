package com.project.gatihaeyo.internal.auth.dto

data class VerifiedAuthCodeDto(
    val email: String,
    val code: String
)