package com.project.gatihaeyo.global

import com.project.gatihaeyo.global.error.ErrorProperty

abstract class GlobalException(
    val errorProperty: ErrorProperty
) : RuntimeException()