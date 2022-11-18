package com.project.gatihaeyo.user.dto.response

import com.project.gatihaeyo.internal.user.dto.response.UserResponse

data class SearchUserResponse(
    val result: List<UserResponse>
)