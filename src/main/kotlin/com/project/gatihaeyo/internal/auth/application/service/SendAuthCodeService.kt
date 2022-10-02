package com.project.gatihaeyo.internal.auth.application.service

import com.project.gatihaeyo.internal.auth.application.port.CommandAuthCodePort
import com.project.gatihaeyo.internal.auth.application.port.SendAuthCodePort
import com.project.gatihaeyo.internal.auth.domain.model.AuthCode
import com.project.gatihaeyo.internal.auth.dto.request.SendAuthCodeRequest
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

//        sendAuthCodePort.sendAuthCode(
//            email = authCode.email,
//            code = authCode.code
//        )
    }

}