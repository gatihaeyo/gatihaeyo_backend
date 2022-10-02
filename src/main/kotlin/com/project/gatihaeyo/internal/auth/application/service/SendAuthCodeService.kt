package com.project.gatihaeyo.internal.auth.application.service

import com.project.gatihaeyo.internal.auth.application.port.CommandAuthCodePort
import com.project.gatihaeyo.internal.auth.application.port.SendAuthCodePort
import com.project.gatihaeyo.internal.auth.domain.exception.AlreadyUsedEmailException
import com.project.gatihaeyo.internal.auth.domain.model.AuthCode
import com.project.gatihaeyo.internal.auth.dto.request.SendAuthCodeRequest
import com.project.gatihaeyo.internal.user.application.port.QueryUserPort
import org.springframework.stereotype.Service

@Service
class SendAuthCodeService(
    private val queryUserPort: QueryUserPort,
    private val commandAuthCodePort: CommandAuthCodePort,
    private val sendAuthCodePort: SendAuthCodePort
) {

    fun execute(request: SendAuthCodeRequest) {
        if(queryUserPort.existsUserByEmail(request.email)) {
            throw AlreadyUsedEmailException.EXCEPTION
        }

        val authCode = commandAuthCodePort.save(
            AuthCode(request.email)
        )

        sendAuthCodePort.sendAuthCode(
            email = authCode.email,
            code = authCode.code
        )
    }

}