package com.project.gatihaeyo.internal.auth.persistence

import com.project.gatihaeyo.internal.auth.application.port.CommandAuthCodePort
import com.project.gatihaeyo.internal.auth.application.port.QueryAuthCodePort
import com.project.gatihaeyo.internal.auth.persistence.mapper.AuthCodeMapper
import com.project.gatihaeyo.internal.auth.persistence.repository.AuthCodeRepository
import org.springframework.stereotype.Component

@Component
class AuthCodeFacade(
    private val authCodeMapper: AuthCodeMapper,
    private val authCodeRepository: AuthCodeRepository
): QueryAuthCodePort, CommandAuthCodePort {

}