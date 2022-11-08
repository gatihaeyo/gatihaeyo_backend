package com.project.gatihaeyo.internal.domain.exception.image

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.image.FileErrorCode

class CompatibleFileException private constructor() : GlobalException(FileErrorCode.COMPATIBLE_EXTENSION) {

    companion object {
        @JvmField
        val EXCEPTION = CompatibleFileException()
    }

}