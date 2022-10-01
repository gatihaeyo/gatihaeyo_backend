package com.project.gatihaeyo.local.user.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.local.user.domain.error.UserErrorCode

class AlreadyUsedEmailException private constructor() : GlobalException(UserErrorCode.ALREADY_USED_EMAIL) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyUsedEmailException()
    }

}