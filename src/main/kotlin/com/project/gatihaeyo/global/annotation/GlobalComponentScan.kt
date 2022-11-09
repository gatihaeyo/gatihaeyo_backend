package com.project.gatihaeyo.global.annotation

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["com.project.gatihaeyo"],
    includeFilters = [
        Filter(
            type = FilterType.ANNOTATION,
            classes = [
                BusinessService::class
            ]
        )
    ]
)
class GlobalComponentScan {
}