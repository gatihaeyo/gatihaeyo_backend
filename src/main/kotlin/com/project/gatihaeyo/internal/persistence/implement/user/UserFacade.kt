package com.project.gatihaeyo.internal.persistence.implement.user

import com.project.gatihaeyo.internal.application.port.user.CommandUserPort
import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.model.auth.User
import com.project.gatihaeyo.internal.persistence.mapper.user.UserMapper
import com.project.gatihaeyo.internal.persistence.repository.user.UserJpaRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserFacade(
    private val userMapper: UserMapper,
    private val userJpaRepository: UserJpaRepository
) : QueryUserPort, CommandUserPort {

    override fun save(model: User): User {
        return userMapper.toDomain(
            userJpaRepository.save(
                userMapper.toEntity(model)
            )
        )!!
    }

    override fun queryUserById(id: UUID): User? {
        return userMapper.toDomain(
            userJpaRepository.queryUserEntityById(id)
        )
    }

    override fun queryUserByNickname(nickname: String): User? {
        return userMapper.toDomain(
            userJpaRepository.queryUserEntityByNickname(nickname)
        )
    }

    override fun queryUserByEmail(email: String): User? {
        return userMapper.toDomain(
            userJpaRepository.queryUserEntityByEmail(email)
        )
    }

    override fun existsUserByEmail(email: String): Boolean {
        return userJpaRepository.existsUserEntityByEmail(email)
    }

    override fun existsUserByNickname(nickname: String): Boolean {
        return userJpaRepository.existsUserEntityByNickname(nickname)
    }

    override fun queryUserListByNickname(nickname: String): List<User> {
        return userJpaRepository.queryUserEntitiesByNicknameContaining(nickname)
            .map {
                userMapper.toDomain(it)!!
            }
    }

}