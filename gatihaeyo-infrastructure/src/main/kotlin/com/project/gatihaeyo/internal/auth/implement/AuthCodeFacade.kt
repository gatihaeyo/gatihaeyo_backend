package com.project.gatihaeyo.internal.auth.implement

import com.project.gatihaeyo.internal.auth.model.AuthCode
import com.project.gatihaeyo.internal.auth.port.CommandAuthCodePort
import com.project.gatihaeyo.internal.auth.port.QueryAuthCodePort
import com.project.gatihaeyo.internal.auth.mapper.AuthCodeMapper
import com.project.gatihaeyo.internal.auth.repository.AuthCodeRepository
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