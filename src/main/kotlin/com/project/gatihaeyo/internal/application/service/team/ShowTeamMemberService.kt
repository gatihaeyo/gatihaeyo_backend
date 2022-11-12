package com.project.gatihaeyo.internal.application.service.team

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.application.port.team.QueryTeamMemberPort
import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.exception.user.UserNotFoundException
import com.project.gatihaeyo.internal.dto.response.team.ShowTeamMemberResponse
import java.util.UUID

@ReadOnlyBusinessService
class ShowTeamMemberService(
    private val queryUserPort: QueryUserPort,
    private val queryTeamMemberPort: QueryTeamMemberPort
) {

    fun execute(teamId: UUID): ShowTeamMemberResponse {
        val list = queryTeamMemberPort.queryTeamMemberListByTeamId(teamId)

        val members = list.map {
            queryUserPort.queryUserById(it.userId) ?: throw UserNotFoundException.EXCEPTION
        }

        return ShowTeamMemberResponse(
            members.map {
                ShowTeamMemberResponse.ShowTeamMemberElement(
                    id = it.id,
                    nickname = it.nickname,
                    profileImagePath = it.profileImagePath
                )
            }
        )
    }
}