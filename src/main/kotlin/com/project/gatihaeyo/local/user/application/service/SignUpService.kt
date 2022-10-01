package com.project.gatihaeyo.local.user.application.service

import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.global.security.token.JwtGenerator
import com.project.gatihaeyo.local.user.dto.request.SignUpRequest
import com.project.gatihaeyo.local.token.dto.response.TokenResponse
import com.project.gatihaeyo.local.user.application.port.CommandUserPort
import com.project.gatihaeyo.local.user.application.port.QueryUserPort
import com.project.gatihaeyo.local.user.domain.exception.AlreadyUsedEmailException
import com.project.gatihaeyo.local.user.domain.exception.AlreadyUsedNicknameException
import com.project.gatihaeyo.local.user.domain.model.Authority
import com.project.gatihaeyo.local.user.domain.model.User
import org.springframework.stereotype.Service

@Service
class SignUpService(
    private val queryUserPort: QueryUserPort,
    private val commandUserPort: CommandUserPort,
    private val securityService: SecurityService,
    private val jwtGenerator: JwtGenerator
) {

    fun execute(request: SignUpRequest) : TokenResponse {
        if(queryUserPort.existsUserByNickname(request.nickname)) {
            throw AlreadyUsedNicknameException.EXCEPTION
        }

        if (queryUserPort.existsUserByEmail(request.email)) {
            throw AlreadyUsedEmailException.EXCEPTION
        }

        val user = commandUserPort.save(
            User(
                nickname = request.nickname,
                email = request.email,
                authority = Authority.ROLE_USER,
                password = securityService.encode(request.password),
                profileImagePath = User.defaultProfile
            )
        )

        return jwtGenerator.issuanceToken(
            userId = user.id,
            authority = user.authority
        )
    }

}