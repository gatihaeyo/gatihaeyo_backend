package com.project.gatihaeyo.internal.presentation

import com.project.gatihaeyo.internal.image.application.service.UploadImageService
import com.project.gatihaeyo.internal.image.dto.request.UploadImageRequest
import com.project.gatihaeyo.internal.image.dto.response.UploadImageResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/images")
@RestController
class ImageController(
    private val uploadImageService: UploadImageService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun upload(@Valid request: UploadImageRequest): UploadImageResponse {
        return UploadImageResponse(
            uploadImageService.execute(request)
        )
    }

}