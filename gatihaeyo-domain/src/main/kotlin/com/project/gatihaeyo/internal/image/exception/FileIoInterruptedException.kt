package com.project.gatihaeyo.internal.image.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.image.error.FileErrorCode.FILE_IO_INTERRUPTED

class FileIoInterruptedException private constructor() : GlobalException(FILE_IO_INTERRUPTED) {

    companion object {
        @JvmField
        val EXCEPTION = FileIoInterruptedException()
    }

}