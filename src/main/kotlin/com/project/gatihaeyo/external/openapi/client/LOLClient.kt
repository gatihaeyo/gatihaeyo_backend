package com.project.gatihaeyo.external.openapi.client

import com.project.gatihaeyo.external.openapi.dto.LOLRecordResponse
import com.project.gatihaeyo.external.openapi.dto.LOLIdResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "LOLClient", url = "https://kr.api.riotgames.com/lol")
interface LOLClient {

    @GetMapping("/summoner/v4/summoners/by-name/{name}")
    fun getAccount(
        @PathVariable("name") name: String,
        @RequestHeader("X-Riot-Token") token: String
    ): LOLIdResponse

    @GetMapping("/league/v4/entries/by-summoner/{key}")
    fun getRecord(
        @PathVariable("key") key: String,
        @RequestHeader("X-Riot-Token") token: String
    ): Array<LOLRecordResponse>

}