package com.project.gatihaeyo.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.gatihaeyo.global.filter.FilterConfig
import com.project.gatihaeyo.global.security.token.JwtParser
import com.project.gatihaeyo.internal.user.domain.model.Authority
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val objectMapper: ObjectMapper,
    private val jwtParser: JwtParser
) {

    @Bean
    protected fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()

            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .authorizeHttpRequests()

            // users
            .antMatchers(HttpMethod.POST, "/users/login").permitAll()
            .antMatchers(HttpMethod.POST, "/users/signup").permitAll()
            .antMatchers(HttpMethod.PUT, "/users/change/password").permitAll()
            .antMatchers(HttpMethod.GET, "/users/info").hasAnyAuthority(Authority.ROLE_USER.name)
            .antMatchers(HttpMethod.PUT, "/users/change/info").hasAnyAuthority(Authority.ROLE_USER.name)
            .antMatchers(HttpMethod.POST, "/users/token/reissue").permitAll()

            // emails
            .antMatchers(HttpMethod.POST, "/emails").permitAll()
            .antMatchers(HttpMethod.POST, "/emails/verified").permitAll()

            // images
            .antMatchers(HttpMethod.POST, "/images").permitAll()

            .anyRequest().authenticated()

            .and()
            .apply(FilterConfig(objectMapper, jwtParser))

            .and()
            .build()
    }

    @Bean
    protected fun PasswordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}