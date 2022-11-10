package com.project.gatihaeyo.internal.domain.exception.team

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.team.TeamErrorCode

class TeamListTopDelayException private constructor() : GlobalException(TeamErrorCode.TEAM_LIST_TOP_DELAY) {

    companion object {
        @JvmField
        val EXCEPTION = TeamListTopDelayException()
    }
}