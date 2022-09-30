package com.project.gatihaeyo.global.error.dto

import org.springframework.validation.BindingResult

class ErrorElement(
    val field: String,
    val value: String,
    val reason: String
) {

    companion object {
        fun of(field: String, value: String, reason: String) = listOf(ErrorElement(field, value, reason))

        fun of(bindingResult: BindingResult) = bindingResult.fieldErrors.map {
            ErrorElement(it.field, it.rejectedValue.toString(), it.defaultMessage!!)
        }
    }
}