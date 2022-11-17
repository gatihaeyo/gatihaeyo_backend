package com.project.gatihaeyo.internal.team.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.team.dto.response.ShowTeamMemberResponse
import com.project.gatihaeyo.internal.team.port.QueryTeamMemberPort
import com.project.gatihaeyo.internal.user.exception.UserNotFoundException
import com.project.gatihaeyo.internal.user.port.QueryUserPort
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