package com.project.gatihaeyo.internal.user.implement

import com.project.gatihaeyo.internal.team.Category
import com.project.gatihaeyo.internal.user.mapper.AccountMapper
import com.project.gatihaeyo.internal.user.mapper.UserMapper
import com.project.gatihaeyo.internal.user.model.AccountEntityId
import com.project.gatihaeyo.internal.user.repository.AccountJpaRepository
import com.project.gatihaeyo.internal.user.model.Account
import com.project.gatihaeyo.internal.user.model.User
import com.project.gatihaeyo.internal.user.port.CommandAccountPort
import com.project.gatihaeyo.internal.user.port.QueryAccountPort
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