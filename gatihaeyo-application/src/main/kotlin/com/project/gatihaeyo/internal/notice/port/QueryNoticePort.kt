package com.project.gatihaeyo.internal.notice.port

import com.project.gatihaeyo.internal.notice.model.Notice
import java.util.UUID

interface QueryNoticePort {

    fun queryNoticeListByUserId(userId: UUID): List<Notice>

    fun existsNoticeById(id: UUID): Boolean
}