package com.project.gatihaeyo.internal.user.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.user.error.UserErrorCode.CANNOT_MAKE_FRIEND_ALONE

class CannotMakeFriendAloneException private constructor() : GlobalException(CANNOT_MAKE_FRIEND_ALONE) {

    companion object {
        @JvmField
        val EXCEPTION = CannotMakeFriendAloneException()
    }
}