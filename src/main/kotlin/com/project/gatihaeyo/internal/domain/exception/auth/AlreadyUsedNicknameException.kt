package com.project.gatihaeyo.internal.domain.exception.auth

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.auth.AuthErrorCode

class AlreadyUsedNicknameException private constructor() : GlobalException(AuthErrorCode.ALREADY_USED_NICKNAME) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyUsedNicknameException()
    }

}