package com.project.gatihaeyo.internal.presentation

import com.project.gatihaeyo.internal.auth.application.service.SendAuthCodeService
import com.project.gatihaeyo.internal.auth.application.service.VerifiedAuthCodeService
import com.project.gatihaeyo.internal.auth.dto.request.SendAuthCodeRequest
import com.project.gatihaeyo.internal.auth.dto.request.VerifiedAuthCodeRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/emails")
@RestController
class EmailController(
    private val sendAuthCodeService: SendAuthCodeService,
    private val verifiedAuthCodeService: VerifiedAuthCodeService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun sendAuthCode(@Valid request: SendAuthCodeRequest) {
        sendAuthCodeService.execute(request)
    }

    @PostMapping("/verified")
    fun verifiedAuthCode(@Valid request: VerifiedAuthCodeRequest) {
        verifiedAuthCodeService.execute(request)
    }

}