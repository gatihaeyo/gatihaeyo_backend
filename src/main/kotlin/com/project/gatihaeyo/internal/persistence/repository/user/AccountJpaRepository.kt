package com.project.gatihaeyo.internal.persistence.repository.user

import com.project.gatihaeyo.internal.persistence.model.user.AccountEntity
import com.project.gatihaeyo.internal.persistence.model.user.AccountEntityId
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AccountJpaRepository : CrudRepository<AccountEntity, AccountEntityId> {

    fun queryAccountEntityByAccountId(accountId: AccountEntityId): AccountEntity?

    @EntityGraph(attributePaths = ["accountId"])
    fun queryAccountEntitiesByAccountId_User_Id(userId: UUID): List<AccountEntity>

}