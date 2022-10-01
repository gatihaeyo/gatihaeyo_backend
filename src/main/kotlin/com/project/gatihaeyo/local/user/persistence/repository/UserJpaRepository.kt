package com.project.gatihaeyo.local.user.persistence.repository

import com.project.gatihaeyo.local.user.persistence.model.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserJpaRepository : CrudRepository<UserEntity, UUID> {

    fun queryUserEntityById(id: UUID): UserEntity?

    fun queryUserEntityByNickname(email: String): UserEntity?

    fun existsUserEntityByNickname(nickname: String): Boolean

    fun existsUserEntityByEmail(email: String): Boolean

}