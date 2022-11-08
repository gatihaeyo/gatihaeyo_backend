package com.project.gatihaeyo.internal.persistence.mapper.user

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.domain.model.user.Account
import com.project.gatihaeyo.internal.persistence.model.user.AccountEntity
import com.project.gatihaeyo.internal.persistence.repository.user.UserJpaRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class AccountMapper : GenericMapper<AccountEntity, Account> {

    @Autowired
    protected lateinit var userJpaRepository: UserJpaRepository

    @Mapping(target = "userId", expression = "java(e.getAccountId().getUser().getId())")
    @Mapping(target = "type", expression = "java(e.getAccountId().getType())")
    abstract override fun toDomain(e: AccountEntity?): Account?

    @Mapping(target = "accountId",
        expression = "java(new AccountEntityId(userJpaRepository.queryUserEntityById(d.getUserId()), d.getType()))")
    abstract override fun toEntity(d: Account): AccountEntity
}