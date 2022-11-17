package com.project.gatihaeyo.global

interface GenericMapper<E, D> {

    fun toDomain(e: E?): D?

    fun toEntity(d: D): E

}