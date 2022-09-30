package com.project.gatihaeyo.global.error

import com.project.gatihaeyo.global.error.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class WebErrorHandler {

    @ExceptionHandler(BindException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleBindException(exception: BindException): ErrorResponse? {
        return ErrorResponse.of(exception.bindingResult)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): ErrorResponse? {
        return ErrorResponse.of(exception.bindingResult)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleConstraintViolationException(exception: ConstraintViolationException): ErrorResponse? {
        return ErrorResponse.of(exception)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleIllegalArgumentException(exception: IllegalArgumentException): ErrorResponse? {
        return ErrorResponse.of(GlobalErrorCode.BAD_REQUEST)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    protected fun handleHttpRequestMethodNotSupportedException(exception: HttpRequestMethodNotSupportedException): ErrorResponse? {
        return ErrorResponse.of(GlobalErrorCode.METHOD_NOT_ALLOWED)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleHttpMessageNotReadableException(exception: HttpMessageNotReadableException): ErrorResponse? {
        return ErrorResponse.of(GlobalErrorCode.BAD_REQUEST)
    }

    @ExceptionHandler(NullPointerException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleNestedServletException(exception: NullPointerException): ErrorResponse? {
        return ErrorResponse.of(GlobalErrorCode.BAD_REQUEST)
    }

}