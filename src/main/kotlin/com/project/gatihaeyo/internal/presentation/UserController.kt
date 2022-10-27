package com.project.gatihaeyo.internal.presentation

import com.project.gatihaeyo.external.openapi.dto.InfoRecordDto
import com.project.gatihaeyo.internal.auth.application.service.ReissueTokenService
import com.project.gatihaeyo.internal.auth.dto.response.TokenResponse
import com.project.gatihaeyo.internal.user.application.service.AccountInfoService
import com.project.gatihaeyo.internal.user.application.service.ChangeInfoService
import com.project.gatihaeyo.internal.user.application.service.ChangePasswordService
import com.project.gatihaeyo.internal.user.application.service.LoginService
import com.project.gatihaeyo.internal.user.application.service.SaveLOLAccountService
import com.project.gatihaeyo.internal.user.application.service.SavePUBGAccountService
import com.project.gatihaeyo.internal.user.application.service.SignUpService
import com.project.gatihaeyo.internal.user.application.service.UserInfoService
import com.project.gatihaeyo.internal.user.dto.request.AccountInfoRequest
import com.project.gatihaeyo.internal.user.dto.request.ChangeInfoRequest
import com.project.gatihaeyo.internal.user.dto.request.ChangePasswordRequest
import com.project.gatihaeyo.internal.user.dto.request.LoginRequest
import com.project.gatihaeyo.internal.user.dto.request.SaveLOLAccountRequest
import com.project.gatihaeyo.internal.user.dto.request.SavePUBGAccountRequest
import com.project.gatihaeyo.internal.user.dto.request.SignUpRequest
import com.project.gatihaeyo.internal.user.dto.response.UserInfoResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
    private val userInfoService: UserInfoService,
    private val changePasswordService: ChangePasswordService,
    private val changeInfoService: ChangeInfoService,
    private val saveLOLAccountService: SaveLOLAccountService,
    private val savePUBGAccountService: SavePUBGAccountService,
    private val AccountInfoService: AccountInfoService
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
    @ResponseStatus(HttpStatus.CREATED)
    fun reissue(@RequestHeader("RefreshToken") request: String): TokenResponse {
        return reissueTokenService.execute(request)
    }

    @GetMapping("/info")
    fun userInfo(): UserInfoResponse {
        return userInfoService.execute()
    }

    @PutMapping("/change/password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun changePassword(@Valid @RequestBody request: ChangePasswordRequest) {
        changePasswordService.execute(request)
    }

    @PutMapping("/change/info")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun changeInfo(@Valid @RequestBody request: ChangeInfoRequest) {
        changeInfoService.execute(request)
    }

    @PutMapping("/game/lol")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun saveLOLAccount(@Valid @RequestBody request: SaveLOLAccountRequest) {
        saveLOLAccountService.execute(request)
    }

    @PutMapping("/game/pubg")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun savePUBGAccount(@Valid @RequestBody request: SavePUBGAccountRequest) {
        savePUBGAccountService.execute(request)
    }

    @GetMapping("/game")
    fun accountInfo(@Valid request: AccountInfoRequest): List<InfoRecordDto> {
        return AccountInfoService.execute(request)
    }

}