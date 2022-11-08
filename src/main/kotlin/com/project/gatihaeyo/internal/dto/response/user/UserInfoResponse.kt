package com.project.gatihaeyo.internal.dto.response.user

import com.project.gatihaeyo.internal.domain.model.Category
import java.util.UUID

data class UserInfoResponse(
    val id: UUID,
    val nickname: String,
    val email: String,
    val profileImagePath: String,
    val accounts: List<AccountInfoResponse>
) {
    data class AccountInfoResponse(
        val name: String,
        val type: Category
    )
}