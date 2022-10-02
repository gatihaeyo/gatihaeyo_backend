package com.project.gatihaeyo.internal.auth.persistence

import com.project.gatihaeyo.internal.auth.application.port.CommandAuthCodePort
import com.project.gatihaeyo.internal.auth.application.port.QueryAuthCodePort
import com.project.gatihaeyo.internal.auth.domain.model.AuthCode
import com.project.gatihaeyo.internal.auth.persistence.mapper.AuthCodeMapper
import com.project.gatihaeyo.internal.auth.persistence.repository.AuthCodeRepository
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
        authCodeRepository.queryAuthCodeEntityByEmail(email)
    )

}