package com.project.gatihaeyo.internal.image.service

import com.project.gatihaeyo.global.annotation.BusinessService
import com.project.gatihaeyo.internal.image.dto.UploadImageDto
import com.project.gatihaeyo.internal.image.exception.CompatibleFileException
import com.project.gatihaeyo.internal.image.port.ManageImagePort
import org.springframework.web.multipart.MultipartFile

@BusinessService
class UploadImageService(
    private val manageImagePort: ManageImagePort
) {

    fun execute(request: UploadImageDto): String {
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