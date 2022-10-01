package com.project.gatihaeyo.global.exception

import com.project.gatihaeyo.global.error.FileErrorCode

class FileIoInterruptedException private constructor() : GlobalException(FileErrorCode.FILE_IO_INTERRUPTED) {

    companion object {
        @JvmField
        val EXCEPTION = FileIoInterruptedException()
    }

}