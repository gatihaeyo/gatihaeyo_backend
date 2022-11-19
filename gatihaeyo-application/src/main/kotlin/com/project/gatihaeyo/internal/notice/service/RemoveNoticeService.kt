package com.project.gatihaeyo.internal.notice.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.notice.exception.NoticeNotFoundException
import com.project.gatihaeyo.internal.notice.port.CommandNoticePort
import com.project.gatihaeyo.internal.notice.port.QueryNoticePort
import java.util.UUID

@BusinessService
class RemoveNoticeService(
    private val queryNoticePort: QueryNoticePort,
    private val commandNoticePort: CommandNoticePort
) {

    fun execute(noticeId: UUID) {
        if (!queryNoticePort.existsNoticeById(noticeId)) {
            throw NoticeNotFoundException.EXCEPTION
        }

        commandNoticePort.deleteNoticeById(noticeId)
    }
}