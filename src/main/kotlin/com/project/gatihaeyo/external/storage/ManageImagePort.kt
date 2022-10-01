package com.project.gatihaeyo.external.storage

import org.springframework.web.multipart.MultipartFile

interface ManageImagePort {

    fun upload(file: MultipartFile): String

}