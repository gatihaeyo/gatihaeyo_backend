package com.project.gatihaeyo.internal.user.repository

import com.project.gatihaeyo.internal.user.model.AccountEntity
import com.project.gatihaeyo.internal.user.model.AccountEntityId
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface AccountJpaRepository : CrudRepository<AccountEntity, AccountEntityId> {

    fun queryAccountEntityByAccountId(accountId: AccountEntityId): AccountEntity?

    @EntityGraph(attributePaths = ["accountId"])
    fun queryAccountEntitiesByAccountId_User_Id(userId: UUID): List<AccountEntity>

}