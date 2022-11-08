package com.project.gatihaeyo.internal.persistence.implement.user

import com.project.gatihaeyo.internal.application.port.user.CommandAccountPort
import com.project.gatihaeyo.internal.application.port.user.QueryAccountPort
import com.project.gatihaeyo.internal.domain.model.user.Account
import com.project.gatihaeyo.internal.domain.model.Category
import com.project.gatihaeyo.internal.domain.model.user.User
import com.project.gatihaeyo.internal.persistence.mapper.user.AccountMapper
import com.project.gatihaeyo.internal.persistence.mapper.user.UserMapper
import com.project.gatihaeyo.internal.persistence.model.user.AccountEntityId
import com.project.gatihaeyo.internal.persistence.repository.user.AccountJpaRepository
import org.springframework.stereotype.Component
import java.util.UUID

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

    override fun queryAccountByAccountId(user: User, type: Category) = accountMapper.toDomain(
        accountJpaRepository.queryAccountEntityByAccountId(
            AccountEntityId(
                user = userMapper.toEntity(user),
                type = type
            )
        )
    )

    override fun queryAccountByUserId(userId: UUID): List<Account> = accountJpaRepository
        .queryAccountEntitiesByAccountId_User_Id(userId).map {
            accountMapper.toDomain(it)!!
        }


}