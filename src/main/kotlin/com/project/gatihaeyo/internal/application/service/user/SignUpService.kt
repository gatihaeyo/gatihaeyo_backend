package com.project.gatihaeyo.internal.application.service.user

import com.project.gatihaeyo.global.security.SecurityService
import com.project.gatihaeyo.global.security.token.JwtGenerator
import com.project.gatihaeyo.internal.application.port.auth.QueryAuthCodePort
import com.project.gatihaeyo.internal.dto.request.user.SignUpRequest
import com.project.gatihaeyo.internal.dto.response.auth.TokenResponse
import com.project.gatihaeyo.internal.application.port.user.CommandUserPort
import com.project.gatihaeyo.internal.application.port.user.QueryUserPort
import com.project.gatihaeyo.internal.domain.exception.user.AlreadyUsedEmailException
import com.project.gatihaeyo.internal.domain.exception.user.AlreadyUsedNicknameException
import com.project.gatihaeyo.internal.domain.exception.auth.AuthCodeMismatchException
import com.project.gatihaeyo.internal.domain.exception.auth.UncertifiedEmailException
import com.project.gatihaeyo.internal.domain.model.auth.Authority
import com.project.gatihaeyo.internal.domain.model.user.User
import org.springframework.stereotype.Service

@Service
class SignUpService(
    private val queryUserPort: QueryUserPort,
    private val queryAuthCodePort: QueryAuthCodePort,
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

        val authCode = queryAuthCodePort.queryAuthCodeByEmail(request.email) ?: throw UncertifiedEmailException.EXCEPTION

        if(authCode.code != request.code) {
            throw AuthCodeMismatchException.EXCEPTION
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