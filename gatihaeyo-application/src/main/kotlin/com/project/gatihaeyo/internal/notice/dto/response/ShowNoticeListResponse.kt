package com.project.gatihaeyo.internal.notice.dto.response

import java.time.LocalDateTime
import java.util.UUID

data class ShowNoticeListResponse(
    val list: List<ShowNoticeListElement>
) {
    data class ShowNoticeListElement(
        val id: UUID,
        val content: String,
        val noticeAt: LocalDateTime
    )
}