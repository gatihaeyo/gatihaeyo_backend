package com.project.gatihaeyo.user.dto.request

import org.hibernate.validator.constraints.Length

data class ChangeInfoRequest(
    @field:Length(min = 4, max = 16)
    val nickname: String,

    val profileImagePath: String?
)