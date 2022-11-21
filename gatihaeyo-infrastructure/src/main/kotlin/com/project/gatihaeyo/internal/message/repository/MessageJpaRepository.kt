package com.project.gatihaeyo.internal.message.repository

import com.project.gatihaeyo.internal.message.model.MessageEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface MessageJpaRepository : CrudRepository<MessageEntity, UUID> {
}