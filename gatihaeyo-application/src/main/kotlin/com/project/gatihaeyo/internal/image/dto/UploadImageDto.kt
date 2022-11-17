package com.project.gatihaeyo.internal.image.dto

import org.springframework.web.multipart.MultipartFile

data class UploadImageDto(
    val image: MultipartFile
)