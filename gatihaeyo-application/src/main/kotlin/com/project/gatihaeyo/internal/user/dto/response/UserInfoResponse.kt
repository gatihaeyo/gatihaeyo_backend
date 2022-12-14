package com.project.gatihaeyo.internal.user.dto.response

import com.project.gatihaeyo.internal.team.Category
import java.util.UUID

data class UserInfoResponse(
    val id: UUID,
    val nickname: String,
    val email: String,
    val profileImagePath: String,
    val followCount: Int,
    val accounts: List<AccountInfoResponse>
) {
    data class AccountInfoResponse(
        val name: String,
        val type: Category
    )
}