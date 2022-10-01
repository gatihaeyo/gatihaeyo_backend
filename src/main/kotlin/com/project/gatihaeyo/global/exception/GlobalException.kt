package com.project.gatihaeyo.global.exception

import com.project.gatihaeyo.global.error.ErrorProperty

abstract class GlobalException(
    val errorProperty: ErrorProperty
) : RuntimeException()