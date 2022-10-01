package com.project.gatihaeyo.local.user.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.local.user.domain.error.UserErrorCode

class AlreadyUsedNicknameException private constructor() : GlobalException(UserErrorCode.ALREADY_USED_NICKNAME) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyUsedNicknameException()
    }

}