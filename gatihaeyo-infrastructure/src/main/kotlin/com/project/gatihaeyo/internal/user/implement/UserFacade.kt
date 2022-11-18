package com.project.gatihaeyo.internal.user.implement

import com.project.gatihaeyo.internal.user.mapper.UserMapper
import com.project.gatihaeyo.internal.user.model.User
import com.project.gatihaeyo.internal.user.port.CommandUserPort
import com.project.gatihaeyo.internal.user.port.QueryUserPort
import com.project.gatihaeyo.internal.user.repository.UserJpaRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UserFacade(
    private val userMapper: UserMapper,
    private val userJpaRepository: UserJpaRepository
) : QueryUserPort, CommandUserPort {

    override fun saveUser(user: User): User {
        return userMapper.toDomain(
            userJpaRepository.save(
                userMapper.toEntity(user)
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