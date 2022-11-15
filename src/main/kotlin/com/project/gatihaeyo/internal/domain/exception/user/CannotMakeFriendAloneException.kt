package com.project.gatihaeyo.internal.domain.exception.user

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.user.UserErrorCode

class CannotMakeFriendAloneException private constructor() : GlobalException(UserErrorCode.CANNOT_MAKE_FRIEND_ALONE) {

    companion object {
        @JvmField
        val EXCEPTION = CannotMakeFriendAloneException()
    }
}