package com.project.gatihaeyo.internal.team

import com.project.gatihaeyo.internal.Order

enum class OrderType(
    val value: Order
) {

    PERSONNEL(Order.PERSONNEL),
    RECENT(Order.RECENT)

}