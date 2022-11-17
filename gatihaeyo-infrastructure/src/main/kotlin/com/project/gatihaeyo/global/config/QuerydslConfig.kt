package com.project.gatihaeyo.global.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager

@Configuration
class QuerydslConfig (
    private val entityManager: EntityManager
) {

    @Bean
    fun queryFactory(): JPAQueryFactory = JPAQueryFactory(entityManager)
}