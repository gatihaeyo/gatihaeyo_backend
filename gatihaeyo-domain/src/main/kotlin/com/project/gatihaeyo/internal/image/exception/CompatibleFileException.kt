package com.project.gatihaeyo.internal.image.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.image.error.FileErrorCode.COMPATIBLE_EXTENSION

class CompatibleFileException private constructor() : GlobalException(COMPATIBLE_EXTENSION) {

    companion object {
        @JvmField
        val EXCEPTION = CompatibleFileException()
    }

}