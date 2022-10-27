package com.project.gatihaeyo.internal.user.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.user.domain.error.UserErrorCode

class AccountNotFoundException private constructor() : GlobalException(UserErrorCode.ACCOUNT_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = AccountNotFoundException()
    }
}