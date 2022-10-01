package com.project.gatihaeyo.internal.auth.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.auth.domain.error.AuthErrorCode

class AlreadyUsedNicknameException private constructor() : GlobalException(AuthErrorCode.ALREADY_USED_NICKNAME) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyUsedNicknameException()
    }

}