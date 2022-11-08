package com.project.gatihaeyo.internal.persistence.repository.user

import com.project.gatihaeyo.internal.persistence.model.user.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserJpaRepository : CrudRepository<UserEntity, UUID> {

    fun queryUserEntityById(id: UUID): UserEntity?

    fun queryUserEntityByNickname(nickname: String): UserEntity?

    fun queryUserEntityByEmail(email: String): UserEntity?

    fun existsUserEntityByNickname(nickname: String): Boolean

    fun existsUserEntityByEmail(email: String): Boolean

    fun queryUserEntitiesByNicknameContaining(nickname: String): List<UserEntity>

}