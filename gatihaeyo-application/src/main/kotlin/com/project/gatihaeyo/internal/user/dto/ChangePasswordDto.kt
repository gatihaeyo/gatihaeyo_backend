package com.project.gatihaeyo.internal.user.dto

data class ChangePasswordDto(
    val email: String,

    val code: String,

    val newPassword: String
)