package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamApplicantResponse
import com.project.gatihaeyo.internal.team.port.QueryTeamApplicantPort
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.port.QueryUserPort
import java.util.UUID

@ReadOnlyBusinessService
class ShowTeamApplicantService(
    private val queryTeamApplicantPort: QueryTeamApplicantPort,
    private val queryUserPort: QueryUserPort
) {

    fun execute(teamId: UUID): ShowTeamApplicantResponse {
        val list = queryTeamApplicantPort.queryTeamApplicantByTeamId(teamId)

        val response = list.map {
            queryUserPort.queryUserById(it.userId)?.let { user ->
                ShowTeamApplicantResponse.ShowTeamApplicantElement(
                    id = user.id,
                    nickname = user.nickname,
                    profileImagePath = user.profileImagePath,
                    appliedAt = it.createdAt
                )
            } ?: throw UserNotFoundException.EXCEPTION
        }

        return ShowTeamApplicantResponse(response)
    }

}