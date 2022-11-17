package com.project.gatihaeyo.internal.team.mapper

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.team.model.TeamDelay
import com.project.gatihaeyo.internal.team.model.TeamDelayEntity
import org.mapstruct.Mapper

@Mapper
abstract class TeamDelayMapper : GenericMapper<TeamDelayEntity, TeamDelay> {
}