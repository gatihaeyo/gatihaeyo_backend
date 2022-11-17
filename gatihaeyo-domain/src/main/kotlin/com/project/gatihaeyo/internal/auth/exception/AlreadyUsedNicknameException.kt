package com.project.gatihaeyo.internal.auth.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.auth.error.AuthErrorCode.ALREADY_USED_NICKNAME

class AlreadyUsedNicknameException private constructor() : GlobalException(ALREADY_USED_NICKNAME) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyUsedNicknameException()
    }

}