package com.project.gatihaeyo.internal.image.application.port

import org.springframework.web.multipart.MultipartFile

interface ManageImagePort {

    fun upload(file: MultipartFile): String

}