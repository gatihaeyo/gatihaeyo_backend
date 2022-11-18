package com.project.gatihaeyo.image.dto.request

import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotNull

data class UploadImageRequest(
    @field:NotNull
    val image: MultipartFile
)