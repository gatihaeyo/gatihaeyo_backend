package com.project.gatihaeyo.internal.presentation

import com.project.gatihaeyo.internal.application.service.auth.SendAuthCodeService
import com.project.gatihaeyo.internal.application.service.auth.VerifiedAuthCodeService
import com.project.gatihaeyo.internal.dto.request.auth.SendAuthCodeRequest
import com.project.gatihaeyo.internal.dto.request.auth.VerifiedAuthCodeRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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
    fun sendAuthCode(@Valid @RequestBody request: SendAuthCodeRequest) {
        sendAuthCodeService.execute(request)
    }

    @PostMapping("/verified")
    fun verifiedAuthCode(@Valid @RequestBody request: VerifiedAuthCodeRequest) {
        verifiedAuthCodeService.execute(request)
    }

}