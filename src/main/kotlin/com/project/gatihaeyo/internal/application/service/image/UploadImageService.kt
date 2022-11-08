package com.project.gatihaeyo.internal.application.service.image

import com.project.gatihaeyo.internal.application.port.image.ManageImagePort
import com.project.gatihaeyo.internal.domain.exception.image.CompatibleFileException
import com.project.gatihaeyo.internal.dto.request.image.UploadImageRequest
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class UploadImageService(
    private val manageImagePort: ManageImagePort
) {

    fun execute(request: UploadImageRequest): String {
        if (!isCompatibleFile(request.image)) {
            throw CompatibleFileException.EXCEPTION
        }

        return manageImagePort.upload(request.image)
    }

    private fun isCompatibleFile(file: MultipartFile) = when (file.originalFilename!!
        .substringAfterLast('.', "").lowercase()) {
            "jpg", "jpeg", "png" -> true
            else -> false
        }

}