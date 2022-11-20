package com.project.gatihaeyo.internal.notice.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.notice.dto.response.ShowNoticeListResponse
import com.project.gatihaeyo.internal.notice.port.QueryNoticePort

@ReadOnlyBusinessService
class ShowNoticeListService(
    private val queryNoticePort: QueryNoticePort,
    private val securityPort: SecurityPort
) {

    fun execute() : ShowNoticeListResponse {
        val currentUserId = securityPort.getCurrentUserId()

        val list = queryNoticePort.queryNoticeListByUserId(currentUserId)

        return ShowNoticeListResponse(
            list.map {
                ShowNoticeListResponse.ShowNoticeListElement(
                    id = it.id,
                    content = it.content,
                    noticeAt = it.createdAt
                )
            }
        )
    }

}