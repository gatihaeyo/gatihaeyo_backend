package com.project.gatihaeyo.internal.message.port

import com.project.gatihaeyo.internal.message.model.Message
import java.util.UUID

interface QueryMessagePort {

    fun queryMessageListByRoomId(size: Long, page: Long, roomId: UUID): List<Message>

}