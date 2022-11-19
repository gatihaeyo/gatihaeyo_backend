package com.project.gatihaeyo.internal.notice.port

import com.project.gatihaeyo.internal.notice.model.Notice
import java.util.UUID

interface CommandNoticePort {

    fun saveNotice(notice: Notice): Notice

    fun deleteNoticeById(id: UUID)
}