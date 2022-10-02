package com.project.gatihaeyo.internal.user.dto.request

import org.hibernate.validator.constraints.Length

data class ChangeInfoRequest(
    @field:Length(min = 4, max = 16)
    val nickname: String?,

    val profileImagePath: String?
)