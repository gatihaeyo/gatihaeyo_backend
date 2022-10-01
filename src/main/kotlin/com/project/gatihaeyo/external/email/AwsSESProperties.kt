package com.project.gatihaeyo.external.email

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationPropertiesScan("cloud.aws.ses")
@ConstructorBinding
class AwsSESProperties(
    val source: String
)