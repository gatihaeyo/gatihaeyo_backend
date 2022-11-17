package com.project.gatihaeyo.internal.user.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.dto.response.TokenResponse
import com.project.gatihaeyo.internal.auth.exception.AlreadyUsedEmailException
import com.project.gatihaeyo.internal.auth.exception.AlreadyUsedNicknameException
import com.project.gatihaeyo.internal.auth.exception.AuthCodeMismatchException
import com.project.gatihaeyo.internal.auth.exception.UncertifiedEmailException
import com.project.gatihaeyo.internal.auth.model.Authority
import com.project.gatihaeyo.internal.auth.port.GenerateJwtPort
import com.project.gatihaeyo.internal.auth.port.QueryAuthCodePort
import com.project.gatihaeyo.internal.auth.port.SecurityPort
import com.project.gatihaeyo.internal.user.dto.SignUpDto
import com.project.gatihaeyo.internal.user.model.User
import com.project.gatihaeyo.internal.user.port.CommandUserPort
import com.project.gatihaeyo.internal.user.port.QueryUserPort

@BusinessService
class SignUpService(
    private val queryUserPort: QueryUserPort,
    private val queryAuthCodePort: QueryAuthCodePort,
    private val commandUserPort: CommandUserPort,
    private val securityPort: SecurityPort,
    private val generateJwtPort: GenerateJwtPort
) {

    fun execute(request: SignUpDto) : TokenResponse {
        val (nickname, email, code, password) = request

        if(queryUserPort.existsUserByNickname(nickname)) {
            throw AlreadyUsedNicknameException.EXCEPTION
        }

        if (queryUserPort.existsUserByEmail(email)) {
            throw AlreadyUsedEmailException.EXCEPTION
        }

        val authCode = queryAuthCodePort.queryAuthCodeByEmail(email) ?: throw UncertifiedEmailException.EXCEPTION

        if(authCode.code != code) {
            throw AuthCodeMismatchException.EXCEPTION
        }

        val user = commandUserPort.saveUser(
            User(
                nickname = nickname,
                email = email,
                authority = Authority.ROLE_USER,
                password = securityPort.encode(password),
                profileImagePath = User.DEFAULT_IMAGE
            )
        )

        return generateJwtPort.issuanceToken(
            userId = user.id,
            authority = user.authority
        )
    }

}