package com.project.gatihaeyo.internal.persistence.repository.user

import com.project.gatihaeyo.internal.persistence.model.user.FriendEntity
import com.project.gatihaeyo.internal.persistence.model.user.FriendEntityId
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface FriendJpaRepository : CrudRepository<FriendEntity, FriendEntityId> {

    fun queryFriendEntitiesByUserId(userId: UUID): List<FriendEntity>
}