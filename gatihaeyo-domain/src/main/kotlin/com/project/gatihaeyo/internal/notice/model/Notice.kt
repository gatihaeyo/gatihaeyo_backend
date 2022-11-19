package com.project.gatihaeyo.internal.notice.model

import java.time.LocalDateTime
import java.util.UUID

data class Notice(
    val id: UUID = UUID(0, 0),

    val userId: UUID,

    val content: String,

    val createdAt: LocalDateTime = LocalDateTime.now()
) {

    companion object {

        fun followMessage(nickname: String) = "${nickname}님이 팔로우하셨습니다."

    }
}