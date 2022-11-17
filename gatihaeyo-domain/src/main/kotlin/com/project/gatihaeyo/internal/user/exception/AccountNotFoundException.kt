package com.project.gatihaeyo.internal.user.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.user.error.UserErrorCode.ACCOUNT_NOT_FOUND

class AccountNotFoundException private constructor() : GlobalException(ACCOUNT_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = AccountNotFoundException()
    }
}