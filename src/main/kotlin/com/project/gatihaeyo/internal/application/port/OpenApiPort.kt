package com.project.gatihaeyo.internal.application.port

import com.project.gatihaeyo.external.openapi.dto.InfoRecordDto

interface OpenApiPort {

    fun getPUBGId(name: String): String

    fun getPUBGInfo(key: String): List<InfoRecordDto>

    fun getLOLId(name: String): String

    fun getLOLInfo(key: String): List<InfoRecordDto>
}