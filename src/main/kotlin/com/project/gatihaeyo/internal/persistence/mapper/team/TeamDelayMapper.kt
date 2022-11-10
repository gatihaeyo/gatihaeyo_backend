package com.project.gatihaeyo.internal.persistence.mapper.team

import com.project.gatihaeyo.global.GenericMapper
import com.project.gatihaeyo.internal.domain.model.team.TeamDelay
import com.project.gatihaeyo.internal.persistence.model.team.TeamDelayEntity
import org.mapstruct.Mapper

@Mapper
abstract class TeamDelayMapper : GenericMapper<TeamDelayEntity, TeamDelay> {
}