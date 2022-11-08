package com.project.gatihaeyo.internal.application.port.image

import org.springframework.web.multipart.MultipartFile

interface ManageImagePort {

    fun upload(file: MultipartFile): String

}