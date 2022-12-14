package com.project.gatihaeyo.global.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient
import org.springframework.cloud.aws.autoconfigure.context.properties.AwsCredentialsProperties
import org.springframework.cloud.aws.autoconfigure.context.properties.AwsRegionProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AwsSESConfig(
    private val awsCredentialsProperties: AwsCredentialsProperties,
    private val awsRegionProperties: AwsRegionProperties
) {

    @Bean
    fun amazonSimpleEmailService(): AmazonSimpleEmailService {
        val basicAWSCredentials = BasicAWSCredentials(awsCredentialsProperties.accessKey, awsCredentialsProperties.secretKey)

        return AmazonSimpleEmailServiceClient.builder()
            .withCredentials(AWSStaticCredentialsProvider(basicAWSCredentials))
            .withRegion(awsRegionProperties.static)
            .build()
    }

}