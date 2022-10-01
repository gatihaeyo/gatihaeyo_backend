package com.project.gatihaeyo.external.storage

import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@ConfigurationPropertiesScan("cloud.aws.s3")
class AwsS3Properties(
    val bucket: String
)