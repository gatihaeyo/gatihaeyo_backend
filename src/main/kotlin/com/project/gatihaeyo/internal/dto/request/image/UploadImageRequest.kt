package com.project.gatihaeyo.internal.dto.request.image

import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotNull

data class UploadImageRequest(
    @field:NotNull
    val image: MultipartFile
)