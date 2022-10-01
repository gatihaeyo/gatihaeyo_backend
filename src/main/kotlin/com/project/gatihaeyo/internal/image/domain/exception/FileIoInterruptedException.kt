package com.project.gatihaeyo.internal.image.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.image.domain.error.FileErrorCode

class FileIoInterruptedException private constructor() : GlobalException(FileErrorCode.FILE_IO_INTERRUPTED) {

    companion object {
        @JvmField
        val EXCEPTION = FileIoInterruptedException()
    }

}