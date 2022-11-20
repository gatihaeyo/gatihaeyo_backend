package com.project.gatihaeyo.internal.notice.implement

import com.project.gatihaeyo.internal.notice.mapper.NoticeMapper
import com.project.gatihaeyo.internal.notice.model.Notice
import com.project.gatihaeyo.internal.notice.model.QNoticeEntity.noticeEntity
import com.project.gatihaeyo.internal.notice.port.CommandNoticePort
import com.project.gatihaeyo.internal.notice.port.QueryNoticePort
import com.project.gatihaeyo.internal.notice.repository.NoticeJpaRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class NoticeFacade(
    private val noticeMapper: NoticeMapper,
    private val noticeJpaRepository: NoticeJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory
) : QueryNoticePort, CommandNoticePort {
    override fun saveNotice(notice: Notice) = noticeMapper.toDomain(
       noticeJpaRepository.save(
           noticeMapper.toEntity(notice)
       )
    )!!

    override fun deleteNoticeById(id: UUID) {
        noticeJpaRepository.deleteById(id)
    }

    override fun queryNoticeListByUserId(userId: UUID): List<Notice> {
        return jpaQueryFactory.selectFrom(noticeEntity)
            .where(noticeEntity.user.id.eq(userId))
            .orderBy(noticeEntity.createdAt.desc())
            .fetch()
            .map {
                noticeMapper.toDomain(it)!!
            }
    }

    override fun existsNoticeById(id: UUID): Boolean {
        return noticeJpaRepository.existsById(id)
    }

}