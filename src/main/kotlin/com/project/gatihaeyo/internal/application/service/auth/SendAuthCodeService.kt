package com.project.gatihaeyo.internal.application.service.auth

import com.project.gatihaeyo.internal.application.port.auth.CommandAuthCodePort
import com.project.gatihaeyo.internal.application.port.auth.SendAuthCodePort
import com.project.gatihaeyo.internal.domain.model.user.AuthCode
import com.project.gatihaeyo.internal.dto.request.auth.SendAuthCodeRequest
import org.springframework.stereotype.Service

@Service
class SendAuthCodeService(
    private val commandAuthCodePort: CommandAuthCodePort,
    private val sendAuthCodePort: SendAuthCodePort
) {

    fun execute(request: SendAuthCodeRequest) {
        val authCode = commandAuthCodePort.save(
            AuthCode(request.email)
        )

        sendAuthCodePort.sendAuthCode(
            email = authCode.email,
            code = authCode.code
        )
    }

}