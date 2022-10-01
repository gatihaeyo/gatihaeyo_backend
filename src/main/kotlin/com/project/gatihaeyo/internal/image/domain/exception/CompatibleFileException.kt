package com.project.gatihaeyo.internal.image.domain.exception

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.image.domain.error.FileErrorCode

class CompatibleFileException private constructor() : GlobalException(FileErrorCode.COMPATIBLE_EXTENSION) {

    companion object {
        @JvmField
        val EXCEPTION = CompatibleFileException()
    }

}