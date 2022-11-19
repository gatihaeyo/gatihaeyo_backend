package com.project.gatihaeyo.internal.user.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.user.error.UserErrorCode.CANNOT_FOLLOW_ALONE

class CannotFollowAloneException private constructor() : GlobalException(CANNOT_FOLLOW_ALONE) {

    companion object {
        @JvmField
        val EXCEPTION = CannotFollowAloneException()
    }
}