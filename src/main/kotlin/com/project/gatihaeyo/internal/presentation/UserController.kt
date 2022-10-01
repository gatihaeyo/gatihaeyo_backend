package com.project.gatihaeyo.internal.presentation

import com.project.gatihaeyo.internal.user.dto.request.LoginRequest
import com.project.gatihaeyo.internal.user.dto.request.SignUpRequest
import com.project.gatihaeyo.internal.auth.dto.response.TokenResponse
import com.project.gatihaeyo.internal.auth.application.service.ReissueTokenService
import com.project.gatihaeyo.internal.user.application.service.LoginService
import com.project.gatihaeyo.internal.user.application.service.SignUpService
import com.project.gatihaeyo.internal.user.application.service.UserInfoService
import com.project.gatihaeyo.internal.user.dto.response.UserInfoResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
    private val signUpService: SignUpService,
    private val loginService: LoginService,
    private val reissueTokenService: ReissueTokenService,
    private val userInfoService: UserInfoService
) {

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@Valid @RequestBody request: SignUpRequest): TokenResponse {
        return signUpService.execute(request)
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): TokenResponse {
        return loginService.execute(request)
    }

    @PostMapping("/token/reissue")
    fun reissue(@RequestHeader("RefreshToken") request: String): TokenResponse {
        return reissueTokenService.execute(request)
    }

    @GetMapping("/info")
    fun userInfo(): UserInfoResponse {
        return userInfoService.execute()
    }

}