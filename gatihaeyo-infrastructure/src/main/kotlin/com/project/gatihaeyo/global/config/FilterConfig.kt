package com.project.gatihaeyo.global.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.gatihaeyo.global.filter.GlobalExceptionFilter
import com.project.gatihaeyo.global.filter.JwtFilter
import com.project.gatihaeyo.global.security.token.JwtParser
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class FilterConfig(
    private val objectMapper: ObjectMapper,
    private val jwtParser: JwtParser
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtFilter(jwtParser), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(GlobalExceptionFilter(objectMapper), JwtFilter::class.java)
    }
}