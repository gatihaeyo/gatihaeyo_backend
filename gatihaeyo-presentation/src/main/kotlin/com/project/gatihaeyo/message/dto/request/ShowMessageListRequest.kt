package com.project.gatihaeyo.message.dto.request

import java.util.UUID
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class ShowMessageListRequest(
    @field:NotNull
    val teamId: UUID,

    @field:NotNull
    @field:Positive
    val size: Long,

    @field:NotNull
    val page: Long = 1
)