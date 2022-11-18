package com.project.gatihaeyo.auth

import com.project.gatihaeyo.auth.dto.request.SendAuthCodeRequest
import com.project.gatihaeyo.auth.dto.request.VerifiedAuthCodeRequest
import com.project.gatihaeyo.internal.auth.dto.SendAuthCodeDto
import com.project.gatihaeyo.internal.auth.dto.VerifiedAuthCodeDto
import com.project.gatihaeyo.internal.auth.service.SendAuthCodeService
import com.project.gatihaeyo.internal.auth.service.VerifiedAuthCodeService
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
        sendAuthCodeService.execute(SendAuthCodeDto(request.email))
    }

    @PostMapping("/verified")
    fun verifiedAuthCode(@Valid @RequestBody request: VerifiedAuthCodeRequest) {
        verifiedAuthCodeService.execute(
            VerifiedAuthCodeDto(
                email = request.email,
                code = request.code
            )
        )
    }

}