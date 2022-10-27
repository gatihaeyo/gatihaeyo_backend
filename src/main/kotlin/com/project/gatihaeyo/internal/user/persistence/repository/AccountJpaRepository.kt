package com.project.gatihaeyo.internal.user.persistence.repository

import com.project.gatihaeyo.internal.user.persistence.model.AccountEntity
import com.project.gatihaeyo.internal.user.persistence.model.AccountEntityId
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountJpaRepository : CrudRepository<AccountEntity, AccountEntityId> {

    fun queryAccountEntityByAccountId(accountId: AccountEntityId): AccountEntity?

}