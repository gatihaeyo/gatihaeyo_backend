package com.project.gatihaeyo.internal.domain.exception.user

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.user.UserErrorCode

class AccountNotFoundException private constructor() : GlobalException(UserErrorCode.ACCOUNT_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = AccountNotFoundException()
    }
}