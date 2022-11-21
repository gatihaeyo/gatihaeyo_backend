package com.project.gatihaeyo.user.dto.response

import com.project.gatihaeyo.internal.team.dto.response.ShowTeamResponse

data class ShowEmbeddedTeamResponse(
    val list: List<ShowTeamResponse>
)