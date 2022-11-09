package com.project.gatihaeyo.global.annotation

import org.springframework.transaction.annotation.Transactional

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Transactional
annotation class BusinessService {
}