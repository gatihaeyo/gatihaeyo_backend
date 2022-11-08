package com.project.gatihaeyo.internal.presentation.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.gatihaeyo.global.error.ErrorProperty
import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.global.error.dto.ErrorResponse
import com.project.gatihaeyo.global.exception.InternalServerErrorException
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class GlobalExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: GlobalException) {
            writeErrorCode(e.errorProperty, response)
        } catch (e: Exception) {
            when (e.cause) {
                is GlobalException -> writeErrorCode((e.cause as GlobalException).errorProperty, response)
                else -> {
                    e.printStackTrace()
                    writeErrorCode(InternalServerErrorException.EXCEPTION.errorProperty, response)
                }
            }
        }
    }

    private fun writeErrorCode(exception: ErrorProperty, response: HttpServletResponse) {
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.status = exception.getStatus()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(
            objectMapper.writeValueAsString(
                ErrorResponse.of(exception)
            )
        )
    }

}