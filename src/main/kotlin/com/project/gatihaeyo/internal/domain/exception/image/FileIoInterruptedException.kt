package com.project.gatihaeyo.internal.domain.exception.image

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.image.FileErrorCode

class FileIoInterruptedException private constructor() : GlobalException(FileErrorCode.FILE_IO_INTERRUPTED) {

    companion object {
        @JvmField
        val EXCEPTION = FileIoInterruptedException()
    }

}