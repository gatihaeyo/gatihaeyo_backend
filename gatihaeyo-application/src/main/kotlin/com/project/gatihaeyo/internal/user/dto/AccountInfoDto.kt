package com.project.gatihaeyo.internal.user.dto

import com.project.gatihaeyo.internal.team.CategoryType

data class AccountInfoDto(
    val nickname: String,

    val type: CategoryType
)