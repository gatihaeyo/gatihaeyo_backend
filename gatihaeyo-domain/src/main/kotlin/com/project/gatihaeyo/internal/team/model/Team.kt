package com.project.gatihaeyo.internal.team.model

import com.project.gatihaeyo.global.Default
import com.project.gatihaeyo.internal.Category
import java.time.LocalDateTime
import java.util.UUID

data class Team @Default constructor(
    val id: UUID = UUID(0, 0),

    val master: UUID,

    val title: String,

    val content: String,

    val category: Category,

    val personnel: Int,

    val currentPersonnel: Int,

    val applicantPersonnel: Int,

    val updateAt: LocalDateTime,
) {
    constructor(master: UUID, title: String, content: String, category: Category, personnel: Int) : this(
        master = master,
        title = title,
        content = content,
        category = category,
        personnel = personnel,
        currentPersonnel = 1,
        applicantPersonnel = 0,
        updateAt = LocalDateTime.now()
    )
}