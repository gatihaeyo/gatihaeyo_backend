package com.project.gatihaeyo.internal.user.repository

import com.project.gatihaeyo.internal.user.model.UserEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserJpaRepository : CrudRepository<UserEntity, UUID> {

    fun queryUserEntityById(id: UUID): UserEntity?

    fun queryUserEntityByNickname(nickname: String): UserEntity?

    fun queryUserEntityByEmail(email: String): UserEntity?

    fun existsUserEntityByNickname(nickname: String): Boolean

    fun existsUserEntityByEmail(email: String): Boolean

    fun queryUserEntitiesByNicknameContaining(nickname: String): List<UserEntity>

}