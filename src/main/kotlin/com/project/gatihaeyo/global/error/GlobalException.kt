package com.project.gatihaeyo.global.error

open class GlobalException(
    private val errorProperty: ErrorProperty
) : RuntimeException() {

}