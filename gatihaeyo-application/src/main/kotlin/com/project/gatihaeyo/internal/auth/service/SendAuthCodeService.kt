package com.project.gatihaeyo.internal.auth.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.auth.dto.SendAuthCodeDto
import com.project.gatihaeyo.internal.auth.model.AuthCode
import com.project.gatihaeyo.internal.auth.port.CommandAuthCodePort
import com.project.gatihaeyo.internal.auth.port.SendAuthCodePort

@BusinessService
class SendAuthCodeService(
    private val commandAuthCodePort: CommandAuthCodePort,
    private val sendAuthCodePort: SendAuthCodePort
) {

    fun execute(request: SendAuthCodeDto) {
        val authCode = commandAuthCodePort.save(
            AuthCode(request.email)
        )

        sendAuthCodePort.sendAuthCode(
            email = authCode.email,
            code = authCode.code
        )
    }

}