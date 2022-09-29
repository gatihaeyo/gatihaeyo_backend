package com.project.gatihaeyo.local.user.persistence

import com.project.gatihaeyo.local.user.application.port.CommandUserPort
import com.project.gatihaeyo.local.user.application.port.QueryUserPort
import com.project.gatihaeyo.local.user.domain.model.User
import com.project.gatihaeyo.local.user.persistence.mapper.UserMapper
import com.project.gatihaeyo.local.user.persistence.repository.UserJpaRepository
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

}