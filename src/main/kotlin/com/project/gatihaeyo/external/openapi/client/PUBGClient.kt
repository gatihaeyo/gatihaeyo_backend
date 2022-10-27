package com.project.gatihaeyo.external.openapi.client

import com.project.gatihaeyo.external.openapi.dto.PUBGIdResponse
import com.project.gatihaeyo.external.openapi.dto.PUBGRecordResponse
import com.project.gatihaeyo.external.openapi.dto.PUBGSeasonResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "PUBGClient", url = "https://api.pubg.com/shards/steam")
interface PUBGClient {

    @GetMapping("/players", produces = ["application/vnd.api+json"])
    fun getAccount(
        @RequestHeader("Authorization") token: String,
        @RequestParam("filter[playerNames]") name: String
    ): PUBGIdResponse

    @GetMapping("/seasons", produces = ["application/vnd.api+json"])
    fun getSeasons(
        @RequestHeader("Authorization") token: String
    ): PUBGSeasonResponse

    @GetMapping("/players/{accountId}/seasons/{seasonId}/ranked", produces = ["application/vnd.api+json"])
    fun getRecord(
        @PathVariable("accountId") key: String,
        @PathVariable("seasonId") season: String,
        @RequestHeader("Authorization") token: String
    ): PUBGRecordResponse

}