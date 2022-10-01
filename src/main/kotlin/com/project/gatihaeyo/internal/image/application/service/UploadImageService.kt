package com.project.gatihaeyo.internal.image.application.service

import com.project.gatihaeyo.internal.image.application.port.ManageImagePort
import com.project.gatihaeyo.internal.image.domain.exception.CompatibleFileException
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class UploadImageService(
    private val manageImagePort: ManageImagePort
) {

    fun execute(request: MultipartFile): String {
        if (isCompatibleFile(request)) {
            throw CompatibleFileException.EXCEPTION
        }

        return manageImagePort.upload(request)
    }

    private fun isCompatibleFile(file: MultipartFile) = when (file.originalFilename!!
        .substringAfterLast('.', "").lowercase()) {
            "jpg", "jpeg", "png" -> true
            else -> false
        }

}