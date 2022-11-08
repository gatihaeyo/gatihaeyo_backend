package com.project.gatihaeyo.internal.persistence.model.user

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tb_account")
class AccountEntity(

    @field:EmbeddedId
    val accountId: AccountEntityId,

    @field:NotNull
    val accountKey: String,

    @field:NotBlank
    val name: String

)