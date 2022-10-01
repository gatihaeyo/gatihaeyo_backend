package com.project.gatihaeyo.internal.presentation

import com.project.gatihaeyo.internal.image.application.service.UploadImageService
import com.project.gatihaeyo.internal.image.dto.UploadImageResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/images")
@RestController
class ImageController(
    private val uploadImageService: UploadImageService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun upload(request: MultipartFile): UploadImageResponse {
        return UploadImageResponse(
            uploadImageService.execute(request)
        )
    }

}