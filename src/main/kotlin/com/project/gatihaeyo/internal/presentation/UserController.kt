package com.project.gatihaeyo.internal.presentation

import com.project.gatihaeyo.external.openapi.dto.InfoRecordDto
import com.project.gatihaeyo.internal.application.service.auth.ReissueTokenService
import com.project.gatihaeyo.internal.application.service.user.AccountInfoService
import com.project.gatihaeyo.internal.application.service.user.AppendFriendService
import com.project.gatihaeyo.internal.application.service.user.ChangeInfoService
import com.project.gatihaeyo.internal.application.service.user.ChangePasswordService
import com.project.gatihaeyo.internal.application.service.user.LoginService
import com.project.gatihaeyo.internal.application.service.user.RemoveFriendService
import com.project.gatihaeyo.internal.application.service.user.SaveLOLAccountService
import com.project.gatihaeyo.internal.application.service.user.SavePUBGAccountService
import com.project.gatihaeyo.internal.application.service.user.SearchUserService
import com.project.gatihaeyo.internal.application.service.user.ShowFriendService
import com.project.gatihaeyo.internal.application.service.user.SignUpService
import com.project.gatihaeyo.internal.application.service.user.UserInfoService
import com.project.gatihaeyo.internal.dto.request.user.AccountInfoRequest
import com.project.gatihaeyo.internal.dto.request.user.ChangeInfoRequest
import com.project.gatihaeyo.internal.dto.request.user.ChangePasswordRequest
import com.project.gatihaeyo.internal.dto.request.user.LoginRequest
import com.project.gatihaeyo.internal.dto.request.user.SaveLOLAccountRequest
import com.project.gatihaeyo.internal.dto.request.user.SavePUBGAccountRequest
import com.project.gatihaeyo.internal.dto.request.user.SignUpRequest
import com.project.gatihaeyo.internal.dto.response.auth.TokenResponse
import com.project.gatihaeyo.internal.dto.response.user.SearchUserResponse
import com.project.gatihaeyo.internal.dto.response.user.UserInfoResponse
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
    private val showFriendService: ShowFriendService,
    private val appendFriendService: AppendFriendService,
    private val removeFriendService: RemoveFriendService
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
    fun userInfo(@RequestParam userId: UUID?): UserInfoResponse {
        return userInfoService.execute(userId)
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
        return accountInfoService.execute(request)
    }

    @GetMapping("/target")
    fun searchUser(@RequestParam @NotNull keyword: String): SearchUserResponse {
        val response = SearchUserResponse(
                searchUserService.execute(keyword).map {
                    SearchUserResponse.UserResponse(
                        id = it.id,
                        nickname = it.nickname,
                        email = it.email,
                        profileImagePath = it.profileImagePath
                    )
                }
        )

        return response
    }

    @GetMapping("/friend")
    fun friendList(): SearchUserResponse {
        val response = SearchUserResponse(
            showFriendService.execute().map {
                SearchUserResponse.UserResponse(
                    id = it.id,
                    nickname = it.nickname,
                    email = it.email,
                    profileImagePath = it.profileImagePath
                )
            }
        )

        return response
    }

    @PutMapping("/friend/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun appendFriend(@PathVariable("user-id") friendId: UUID) {
        appendFriendService.execute(friendId)
    }

    @DeleteMapping("/friend/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeFriend(@PathVariable("user-id") friendId: UUID) {
        removeFriendService.execute(friendId)
    }

}