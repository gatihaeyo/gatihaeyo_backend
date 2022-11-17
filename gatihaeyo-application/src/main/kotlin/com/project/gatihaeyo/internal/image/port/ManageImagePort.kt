package com.project.gatihaeyo.internal.image.port

import org.springframework.web.multipart.MultipartFile

interface ManageImagePort {

    fun upload(file: MultipartFile): String

}