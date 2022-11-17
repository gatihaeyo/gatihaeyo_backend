package com.project.gatihaeyo.global.filter

import com.project.gatihaeyo.global.security.token.JwtComponent
import com.project.gatihaeyo.global.security.token.JwtParser
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtFilter(
    private val jwtParser: JwtParser
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        resolveToken(request)?.run {
            SecurityContextHolder.getContext().authentication = jwtParser.getAuthentication(this)
        }

        filterChain.doFilter(request, response)
    }

    private fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(JwtComponent.HEADER)

        if(bearerToken != null && bearerToken.startsWith(JwtComponent.PREFIX)) {
            return bearerToken.substring(7)
        }

        return null
    }

}