package com.project.gatihaeyo.internal.message.implement

import com.project.gatihaeyo.internal.message.mapper.MessageMapper
import com.project.gatihaeyo.internal.message.model.Message
import com.project.gatihaeyo.internal.message.model.QMessageEntity.messageEntity
import com.project.gatihaeyo.internal.message.port.CommandMessagePort
import com.project.gatihaeyo.internal.message.port.QueryMessagePort
import com.project.gatihaeyo.internal.message.repository.MessageJpaRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class MessageFacade(
    private val messageMapper: MessageMapper,
    private val messageJpaRepository: MessageJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory
) : CommandMessagePort, QueryMessagePort {

    override fun saveMessage(message: Message) = messageMapper.toDomain(
        messageJpaRepository.save(
            messageMapper.toEntity(message)
        )
    )!!

    override fun queryMessageListByRoomId(size: Long, page: Long, roomId: UUID): List<Message> {
    return jpaQueryFactory.selectFrom(messageEntity)
        .where(messageEntity.room.id.eq(roomId))
        .orderBy(messageEntity.createdAt.desc())
        .offset(page * size)
        .limit(size)
        .fetch()
        .map {
            messageMapper.toDomain(it)!!
        }
    }


}