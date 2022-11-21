package com.project.gatihaeyo.internal.message.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.message.dto.ShowMessageListDto
import com.project.gatihaeyo.internal.message.dto.response.ShowMessageResponse
import com.project.gatihaeyo.internal.message.port.QueryMessagePort
import com.project.gatihaeyo.internal.team.exception.TeamMemberNotFoundException
import com.project.gatihaeyo.internal.team.port.QueryTeamMemberPort

@ReadOnlyBusinessService
class ShowMessageListService(
    private val queryMessagePort: QueryMessagePort,
    private val queryTeamMemberPort: QueryTeamMemberPort,
    private val securityPort: SecurityPort
) {

    fun execute(request: ShowMessageListDto): List<ShowMessageResponse> {
        val currentUserId = securityPort.getCurrentUserId()

        if (queryTeamMemberPort.existsTeamMemberByUserIdAndTeamId(currentUserId, request.roomId)) {
            throw TeamMemberNotFoundException.EXCEPTION
        }

        return queryMessagePort.queryMessageListByRoomId(
            size = request.size,
            page = request.page,
            roomId = request.roomId
        ).map {
            ShowMessageResponse(
                id = it.id,
                sender = it.userId,
                message = it.message,
                timestamp = it.createdAt
            )
        }
    }

}