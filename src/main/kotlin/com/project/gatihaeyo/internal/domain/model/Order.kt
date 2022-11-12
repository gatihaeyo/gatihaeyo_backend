package com.project.gatihaeyo.internal.domain.model

import com.project.gatihaeyo.internal.persistence.model.team.QTeamEntity.teamEntity
import com.querydsl.core.types.OrderSpecifier

enum class Order(
    val sort: OrderSpecifier<*>
) {

    PERSONNEL(teamEntity.personnel.desc()),
    RECENT(teamEntity.updateAt.desc());
}