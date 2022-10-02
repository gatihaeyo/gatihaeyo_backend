package com.project.gatihaeyo.internal.user.persistence

import com.project.gatihaeyo.internal.user.application.port.CommandUserPort
import com.project.gatihaeyo.internal.user.application.port.QueryUserPort
import com.project.gatihaeyo.internal.user.domain.model.User
import com.project.gatihaeyo.internal.user.persistence.mapper.UserMapper
import com.project.gatihaeyo.internal.user.persistence.repository.UserJpaRepository
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

}