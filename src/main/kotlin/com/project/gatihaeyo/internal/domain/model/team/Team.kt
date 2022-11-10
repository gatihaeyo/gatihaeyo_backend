package com.project.gatihaeyo.internal.domain.model.team

import com.project.gatihaeyo.global.annotation.Default
import com.project.gatihaeyo.internal.domain.model.Category
import java.time.LocalDateTime
import java.util.UUID

data class Team @Default constructor(
    val id: UUID = UUID(0, 0),

    val master: UUID,

    val title: String,

    val category: Category,

    val personnel: Int,

    val currentPersonnel: Int,

    val applicantPersonnel: Int,

    val updateAt: LocalDateTime,

    val createAt: LocalDateTime
) {
    constructor(master: UUID, title: String, category: Category, personnel: Int) : this(
        master = master,
        title = title,
        category = category,
        personnel = personnel,
        currentPersonnel = 1,
        applicantPersonnel = 0,
        updateAt = LocalDateTime.now(),
        createAt = LocalDateTime.now()
    )
}