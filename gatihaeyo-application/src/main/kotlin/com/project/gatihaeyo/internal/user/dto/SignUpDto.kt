package com.project.gatihaeyo.internal.user.dto

data class SignUpDto(
    val nickname: String,

    val email: String,

    val code: String,

    val password: String
)