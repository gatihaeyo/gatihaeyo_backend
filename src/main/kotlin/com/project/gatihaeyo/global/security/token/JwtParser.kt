package com.project.gatihaeyo.global.security.token

import com.project.gatihaeyo.global.exception.InternalServerErrorException
import com.project.gatihaeyo.global.security.SecurityProperties
import com.project.gatihaeyo.global.security.exception.ExpiredTokenException
import com.project.gatihaeyo.global.security.exception.InvalidTokenException
import com.project.gatihaeyo.global.security.exception.UnexpectedTokenException
import com.project.gatihaeyo.global.security.exception.WrongTypeTokenException
import com.project.gatihaeyo.global.security.principle.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Header
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jws
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication

import org.springframework.stereotype.Component

@Component
class JwtParser(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) {

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)

        if (claims.header[Header.JWT_TYPE] != JwtComponent.ACCESS) {
           throw WrongTypeTokenException.EXCEPTION
        }

        val authDetails = authDetailsService.loadUserByUsername(claims.body.id)

        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

    private fun getClaims(token: String): Jws<Claims> {
        return try {
            Jwts.parser()
                .setSigningKey(securityProperties.encodingSecretKey)
                .parseClaimsJws(token)
        } catch (e: Exception) {
            when (e) {
                is InvalidClaimException -> throw InvalidTokenException.EXCEPTION
                is ExpiredJwtException -> throw ExpiredTokenException.EXCEPTION
                is JwtException -> throw UnexpectedTokenException.EXCEPTION
                else -> throw InternalServerErrorException.EXCEPTION
            }
        }
    }
}