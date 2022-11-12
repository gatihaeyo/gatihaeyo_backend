package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.internal.application.port.team.QueryTeamApplicantPort
import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.exception.user.UserNotFoundException
import com.project.gatihaeyo.internal.dto.response.team.ShowTeamApplicantResponse

@ReadOnlyBusinessService
class ShowTeamApplicantService(
    private val queryTeamApplicantPort: QueryTeamApplicantPort,
    private val queryUserPort: QueryUserPort,
    private val securityService: SecurityService
) {

    fun execute(): ShowTeamApplicantResponse {
        val currentUserId = securityService.getCurrentUserId()

        val list = queryTeamApplicantPort.queryTeamApplicantListByUserId(currentUserId)

        return ShowTeamApplicantResponse(
            list.map {
                queryUserPort.queryUserById(it.userId)?.let { member ->
                    ShowTeamApplicantResponse.ShowTeamApplicantElement(
                        id = member.id,
                        nickname = member.nickname,
                        profileImagePath = member.profileImagePath,
                        applyAt = it.createAt
                    )
                } ?: throw UserNotFoundException.EXCEPTION
            }
        )
    }
}