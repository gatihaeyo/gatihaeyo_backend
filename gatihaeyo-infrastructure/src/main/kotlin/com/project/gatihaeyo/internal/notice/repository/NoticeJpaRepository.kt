package com.project.gatihaeyo.internal.notice.repository

import com.project.gatihaeyo.internal.notice.model.NoticeEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface NoticeJpaRepository : CrudRepository<NoticeEntity, UUID> {
}