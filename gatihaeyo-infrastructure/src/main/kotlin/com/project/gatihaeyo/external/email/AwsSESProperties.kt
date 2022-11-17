package com.project.gatihaeyo.external.email

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("cloud.aws.ses")
@ConstructorBinding
class AwsSESProperties(
    val source: String
)