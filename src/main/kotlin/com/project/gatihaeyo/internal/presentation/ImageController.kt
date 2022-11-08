package com.project.gatihaeyo.internal.presentation

import com.project.gatihaeyo.internal.application.service.image.UploadImageService
import com.project.gatihaeyo.internal.dto.request.image.UploadImageRequest
import com.project.gatihaeyo.internal.dto.response.image.UploadImageResponse
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