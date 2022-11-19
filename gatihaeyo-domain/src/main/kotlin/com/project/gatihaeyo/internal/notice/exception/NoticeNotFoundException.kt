package com.project.gatihaeyo.internal.notice.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.notice.error.NoticeErrorCode.NOTICE_NOT_FOUND

class NoticeNotFoundException private constructor() : GlobalException(NOTICE_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = NoticeNotFoundException()
    }

}