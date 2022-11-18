package com.project.gatihaeyo.internal.user.repository

import com.project.gatihaeyo.internal.user.model.FollowEntity
import com.project.gatihaeyo.internal.user.model.FollowEntityId
import org.springframework.data.repository.CrudRepository

interface FollowJpaRepository : CrudRepository<FollowEntity, FollowEntityId> {
}