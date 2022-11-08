package com.project.gatihaeyo.internal.domain.model.team

import com.project.gatihaeyo.global.annotation.Default
import com.project.gatihaeyo.internal.domain.model.Category
import java.util.Date
import java.util.UUID

data class Team @Default constructor(
    val id: UUID = UUID(0, 0),

    val master: UUID,

    val title: String,

    val category: Category,

    val personnel: Int,

    val currentPersonnel: Int,

    val updateAt: Date
) {
    constructor(master: UUID, title: String, category: Category, personnel: Int) : this(
        master = master,
        title = title,
        category = category,
        personnel = personnel,
        currentPersonnel = 1,
        updateAt = Date()
    )
}