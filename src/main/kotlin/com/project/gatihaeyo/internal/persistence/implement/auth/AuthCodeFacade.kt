package com.project.gatihaeyo.internal.persistence.implement.auth

import com.project.gatihaeyo.internal.application.port.auth.CommandAuthCodePort
import com.project.gatihaeyo.internal.application.port.auth.QueryAuthCodePort
import com.project.gatihaeyo.internal.domain.model.user.AuthCode
import com.project.gatihaeyo.internal.persistence.mapper.auth.AuthCodeMapper
import com.project.gatihaeyo.internal.persistence.repository.auth.AuthCodeRepository
import org.springframework.stereotype.Component

@Component
class AuthCodeFacade(
    private val authCodeMapper: AuthCodeMapper,
    private val authCodeRepository: AuthCodeRepository
): QueryAuthCodePort, CommandAuthCodePort {

    override fun save(code: AuthCode) = authCodeMapper.toDomain(
        authCodeRepository.save(
            authCodeMapper.toEntity(code)
        )
    )!!

    override fun queryAuthCodeByEmail(email: String) = authCodeMapper.toDomain(
        authCodeRepository.findById(email).orElse(null)
    )

}