package com.project.gatihaeyo.global.error.dto

import com.project.gatihaeyo.global.error.ErrorProperty
import com.project.gatihaeyo.global.error.GlobalErrorCode
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.validation.BindingResult
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.validation.ConstraintViolationException

class ErrorResponse(
    val status: Int,
    val message: String,
    val fieldErrors: List<ErrorElement>
) {

    companion object {
        fun of(exception: ErrorProperty) = ErrorResponse(
            status = exception.getStatus(),
            message = exception.getMessage(),
            fieldErrors = emptyList()
        )

        fun of(bindingResult: BindingResult): ErrorResponse = of(
            exception = GlobalErrorCode.BAD_REQUEST,
            fieldErrors = ErrorElement.of(bindingResult)
        )

        fun of(exception: ConstraintViolationException): ErrorResponse {
            val fieldErrors = exception.constraintViolations.flatMap {
                val path = it.propertyPath
                val field = path.last().name
                val message = it.message
                println("$path\n$field\n$message")
                ErrorElement.of(field, "", message)
            }

            return of(
                exception = GlobalErrorCode.BAD_REQUEST,
                fieldErrors = fieldErrors
            )
        }

        fun of(exception: MethodArgumentTypeMismatchException) = of(
            exception = GlobalErrorCode.BAD_REQUEST,
            fieldErrors = ErrorElement.of(exception.name, exception.value.toString(), exception.errorCode)
        )

        fun of(exception: DataIntegrityViolationException): ErrorResponse = of(
            exception = GlobalErrorCode.BAD_REQUEST,
            fieldErrors = ErrorElement.of("", "", exception.message ?: "")
        )

        private fun of(exception: ErrorProperty, fieldErrors: List<ErrorElement>) = ErrorResponse(
            status = exception.getStatus(),
            message = exception.getMessage(),
            fieldErrors = fieldErrors
        )

    }

}