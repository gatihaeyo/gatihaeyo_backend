package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamApplicantResponse
import com.project.gatihaeyo.internal.team.port.QueryTeamApplicantPort
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.port.QueryUserPort

@ReadOnlyBusinessService
class ShowTeamApplicantService(
    private val queryTeamApplicantPort: QueryTeamApplicantPort,
    private val queryUserPort: QueryUserPort,
    private val securityPort: SecurityPort
) {

    fun execute(): ShowTeamApplicantResponse {
        val currentUserId = securityPort.getCurrentUserId()

        val list = queryTeamApplicantPort.queryTeamApplicantListByUserId(currentUserId)

        return ShowTeamApplicantResponse(
            list.map {
                queryUserPort.queryUserById(it.userId)?.let { member ->
                    ShowTeamApplicantResponse.ShowTeamApplicantElement(
                        id = member.id,
                        nickname = member.nickname,
                        profileImagePath = member.profileImagePath,
                        appliedAt = it.createdAt
                    )
                } ?: throw UserNotFoundException.EXCEPTION
            }
        )
    }
}