package com.project.gatihaeyo.internal.user.dto.response

import java.util.UUID

data class UserResponse(
    val id: UUID,
    val nickname: String,
    val email: String,
    val profileImagePath: String,
    val followCount: Int
 )