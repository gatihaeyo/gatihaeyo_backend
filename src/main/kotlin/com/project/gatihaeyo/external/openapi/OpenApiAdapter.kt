package com.project.gatihaeyo.external.openapi

import com.project.gatihaeyo.external.openapi.client.LOLClient
import com.project.gatihaeyo.external.openapi.client.PUBGClient
import com.project.gatihaeyo.external.openapi.dto.InfoRecordDto
import com.project.gatihaeyo.internal.application.port.OpenApiPort
import org.springframework.stereotype.Component
import kotlin.math.round

@Component
class OpenApiAdapter(
    private val openApiProperties: OpenApiProperties,
    private val pubgClient: PUBGClient,
    private val lolClient: LOLClient
): OpenApiPort {

    override fun getPUBGId(name: String): String {
        return pubgClient.getAccount(
            name = name,
            token = openApiProperties.pubg
        ).data[0].id
    }

    override fun getPUBGInfo(key: String): List<InfoRecordDto> {
        val season = pubgClient.getSeasons(
            token = openApiProperties.pubg
        ).data.filter { it.attributes.isCurrentSeason }[0]

        val record = pubgClient.getRecord(
            key = key,
            token = openApiProperties.pubg,
            season = season.id
        )

        val result = mutableListOf<InfoRecordDto>()

        record.data.attributes.rankedGameModeStats.let { it ->
            it.solo?.let {
                result.add(InfoRecordDto(
                    type = "solo",
                    tier = it.currentTier.tier,
                    rank = it.currentTier.subTier,
                    point = it.currentRankPoint,
                    winRatio = rateRound(it.winRatio * 100)
                ))
            }
            it.duo?.let {
                result.add(InfoRecordDto(
                    type = "duo",
                    tier = it.currentTier.tier,
                    rank = it.currentTier.subTier,
                    point = it.currentRankPoint,
                    winRatio = rateRound(it.winRatio * 100)
                ))
            }
            it.squad?.let {
                result.add(InfoRecordDto(
                    type = "squad",
                    tier = it.currentTier.tier,
                    rank = it.currentTier.subTier,
                    point = it.currentRankPoint,
                    winRatio = rateRound(it.winRatio * 100)
                ))
            }
        }

        return result
    }

    override fun getLOLId(name: String): String {
        return lolClient.getAccount(
            name = name,
            token = openApiProperties.leagueOfLegend
        ).id
    }

    override fun getLOLInfo(key: String): List<InfoRecordDto> {
        val record = lolClient.getRecord(
            key = key,
            token = openApiProperties.leagueOfLegend
        )

        return record.map {
            InfoRecordDto(
                tier = it.tier,
                rank = it.rank,
                point = it.leaguePoints,
                winRatio = rateRound(winRate(it.wins + it.losses, it.wins))
            )
        }
    }

    private fun winRate(entire: Int, wins: Int): Double = wins.toDouble().div(entire) * 100

    private fun rateRound(ratio: Double): Double = round(ratio * 100) / 100

}