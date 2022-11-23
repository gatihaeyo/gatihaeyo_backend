package com.project.gatihaeyo.internal.socket.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.global.error.GlobalErrorCode

class MessageNullException private constructor() : GlobalException(GlobalErrorCode.BAD_REQUEST) {

    companion object {
        @JvmField
        val EXCEPTION = MessageNullException()
    }
}