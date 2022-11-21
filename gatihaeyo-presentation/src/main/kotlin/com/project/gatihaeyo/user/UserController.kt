package com.project.gatihaeyo.user

import com.project.gatihaeyo.internal.auth.dto.response.TokenResponse
import com.project.gatihaeyo.internal.auth.service.ReissueTokenService
import com.project.gatihaeyo.internal.user.dto.AccountInfoDto
import com.project.gatihaeyo.internal.user.dto.ChangeInfoDto
import com.project.gatihaeyo.internal.user.dto.ChangePasswordDto
import com.project.gatihaeyo.internal.user.dto.InfoRecordDto
import com.project.gatihaeyo.internal.user.dto.LoginDto
import com.project.gatihaeyo.internal.user.dto.SaveLOLAccountDto
import com.project.gatihaeyo.internal.user.dto.SavePUBGAccountDto
import com.project.gatihaeyo.internal.user.dto.SignUpDto
import com.project.gatihaeyo.internal.user.dto.response.UserInfoResponse
import com.project.gatihaeyo.internal.user.service.AccountInfoService
import com.project.gatihaeyo.internal.user.service.AppendFollowService
import com.project.gatihaeyo.internal.user.service.ChangeInfoService
import com.project.gatihaeyo.internal.user.service.ChangePasswordService
import com.project.gatihaeyo.internal.user.service.LoginService
import com.project.gatihaeyo.internal.user.service.RemoveFollowService
import com.project.gatihaeyo.internal.user.service.SaveLOLAccountService
import com.project.gatihaeyo.internal.user.service.SavePUBGAccountService
import com.project.gatihaeyo.internal.user.service.SearchUserService
import com.project.gatihaeyo.internal.user.service.ShowFollowService
import com.project.gatihaeyo.internal.user.service.SignUpService
import com.project.gatihaeyo.internal.user.service.UserInfoService
import com.project.gatihaeyo.user.dto.request.ChangeInfoRequest
import com.project.gatihaeyo.user.dto.request.ChangePasswordRequest
import com.project.gatihaeyo.user.dto.request.LoginRequest
import com.project.gatihaeyo.user.dto.request.SaveLOLAccountRequest
import com.project.gatihaeyo.user.dto.request.SavePUBGAccountRequest
import com.project.gatihaeyo.user.dto.request.SignUpRequest
import com.project.gatihaeyo.user.dto.request.WebAccountInfoRequest
import com.project.gatihaeyo.user.dto.response.SearchUserResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Validated
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
    private val accountInfoService: AccountInfoService,
    private val searchUserService: SearchUserService,
    private val showFollowService: ShowFollowService,
    private val appendFollowService: AppendFollowService,
    private val removeFollowService: RemoveFollowService
) {

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@Valid @RequestBody request: SignUpRequest): TokenResponse {
        val (nickname, email, code, password) = request

        return signUpService.execute(
            SignUpDto(
                nickname = nickname,
                email = email,
                code = code,
                password = password
            )
        )
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): TokenResponse {
        return loginService.execute(
            LoginDto(
                nickname = request.nickname,
                password = request.password
            )
        )
    }

    @PostMapping("/token/reissue")
    @ResponseStatus(HttpStatus.CREATED)
    fun reissue(@RequestHeader("RefreshToken") request: String): TokenResponse {
        return reissueTokenService.execute(request)
    }

    @GetMapping("/info")
    fun userInfo(@RequestParam userId: UUID?): UserInfoResponse {
        return userInfoService.execute(userId)
    }

    @PutMapping("/change/password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun changePassword(@Valid @RequestBody request: ChangePasswordRequest) {
        changePasswordService.execute(
            ChangePasswordDto(
                email = request.email,
                code = request.code,
                newPassword = request.newPassword
            )
        )
    }

    @PutMapping("/change/info")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun changeInfo(@Valid @RequestBody request: ChangeInfoRequest) {
        changeInfoService.execute(
            ChangeInfoDto(
                nickname = request.nickname,
                profileImagePath = request.profileImagePath
            )
        )
    }

    @PutMapping("/game/lol")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun saveLOLAccount(@Valid @RequestBody request: SaveLOLAccountRequest) {
        saveLOLAccountService.execute(SaveLOLAccountDto(request.name))
    }

    @PutMapping("/game/pubg")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun savePUBGAccount(@Valid @RequestBody request: SavePUBGAccountRequest) {
        savePUBGAccountService.execute(
            SavePUBGAccountDto(request.name)
        )
    }

    @GetMapping("/game")
    fun accountInfo(@Valid request: WebAccountInfoRequest): List<InfoRecordDto> {
        return accountInfoService.execute(
            AccountInfoDto(
                nickname = request.nickname,
                type = request.type
            )
        )
    }

    @GetMapping("/target")
    fun searchUser(@RequestParam @NotNull keyword: String): SearchUserResponse {
        return SearchUserResponse(searchUserService.execute(keyword))
    }

    @GetMapping("/follow")
    fun friendList(): SearchUserResponse {
        return SearchUserResponse(showFollowService.execute())
    }

    @PutMapping("/follow/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun appendFollow(@PathVariable("user-id") followId: UUID) {
        appendFollowService.execute(followId)
    }

    @DeleteMapping("/follow/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeFollow(@PathVariable("user-id") followId: UUID) {
        removeFollowService.execute(followId)
    }

}