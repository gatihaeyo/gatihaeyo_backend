package com.project.gatihaeyo.internal.dto.response.user

import java.util.UUID

data class SearchUserResponse(
    val result: List<UserResponse>
) {
    data class UserResponse(
        val id: UUID,
        val nickname: String,
        val email: String,
        val profileImagePath: String
    )
}