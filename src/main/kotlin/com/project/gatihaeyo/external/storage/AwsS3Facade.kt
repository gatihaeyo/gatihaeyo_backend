package com.project.gatihaeyo.external.storage

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.project.gatihaeyo.internal.image.application.port.ManageImagePort
import com.project.gatihaeyo.internal.image.domain.exception.FileIoInterruptedException
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.UUID

@Component
class AwsS3Facade(
    private val awsS3Properties: AwsS3Properties,
    private val amazonS3Client: AmazonS3Client
): ManageImagePort {

    override fun upload(file: MultipartFile): String {
        val fileName = "${UUID.randomUUID()}@${file.originalFilename}"
        storeS3(file, fileName)

        return getResource(fileName)
    }

    private fun storeS3(file: MultipartFile, fileName: String) {
        try {
            val inputStream = file.inputStream
            val objectMetadata = ObjectMetadata().apply {
                this.contentType = file.contentType
                this.contentLength = file.size
            }

            amazonS3Client.putObject(
                PutObjectRequest(awsS3Properties.bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead)
            )
        } catch (e: IOException) {
            throw FileIoInterruptedException.EXCEPTION
        }
    }

    private fun getResource(fileName: String) = amazonS3Client.getResourceUrl(awsS3Properties.bucket, fileName)

}