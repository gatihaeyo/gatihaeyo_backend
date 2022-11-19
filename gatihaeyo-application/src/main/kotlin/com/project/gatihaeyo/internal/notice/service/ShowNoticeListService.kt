package com.project.gatihaeyo.internal.notice.service

import com.project.gatihaeyo.global.annotation.ReadOnlyBusinessService
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.notice.dto.NoticeDto
import com.project.gatihaeyo.internal.notice.port.QueryNoticePort

@ReadOnlyBusinessService
class ShowNoticeListService(
    private val queryNoticePort: QueryNoticePort,
    private val securityPort: SecurityPort
) {

    fun execute() : List<NoticeDto> {
        val currentUserId = securityPort.getCurrentUserId()

        val list = queryNoticePort.queryNoticeListByUserId(currentUserId)

        return list.map {
            NoticeDto(
                id = it.id,
                content = it.content,
                noticeAt = it.createdAt
            )
        }
    }

}