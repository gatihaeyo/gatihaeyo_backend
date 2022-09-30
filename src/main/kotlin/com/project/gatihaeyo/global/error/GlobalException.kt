package com.project.gatihaeyo.global.error

abstract class GlobalException(
    val errorProperty: ErrorProperty
) : RuntimeException()