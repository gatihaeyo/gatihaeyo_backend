package com.project.gatihaeyo.internal.user.persistence

import com.project.gatihaeyo.internal.user.application.port.CommandAccountPort
import com.project.gatihaeyo.internal.user.application.port.QueryAccountPort
import com.project.gatihaeyo.internal.user.domain.model.Account
import com.project.gatihaeyo.internal.user.domain.model.GameType
import com.project.gatihaeyo.internal.user.domain.model.User
import com.project.gatihaeyo.internal.user.persistence.mapper.AccountMapper
import com.project.gatihaeyo.internal.user.persistence.mapper.UserMapper
import com.project.gatihaeyo.internal.user.persistence.model.AccountEntityId
import com.project.gatihaeyo.internal.user.persistence.repository.AccountJpaRepository
import org.springframework.stereotype.Component

@Component
class AccountFacade(
    private val accountMapper: AccountMapper,
    private val accountJpaRepository: AccountJpaRepository,
    private val userMapper: UserMapper
) : QueryAccountPort, CommandAccountPort {

    override fun save(entity: Account) = accountMapper.toDomain(
        accountJpaRepository.save(
            accountMapper.toEntity(entity)
        )
    )!!

    override fun queryAccountByAccountId(user: User, type: GameType) = accountMapper.toDomain(
        accountJpaRepository.queryAccountEntityByAccountId(
            AccountEntityId(
                user = userMapper.toEntity(user),
                type = type
            )
        )
    )


}