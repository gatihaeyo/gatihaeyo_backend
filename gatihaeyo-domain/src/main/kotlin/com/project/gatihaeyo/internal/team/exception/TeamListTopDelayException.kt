package com.project.gatihaeyo.internal.team.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.team.error.TeamErrorCode.TEAM_LIST_TOP_DELAY

class TeamListTopDelayException private constructor() : GlobalException(TEAM_LIST_TOP_DELAY) {

    companion object {
        @JvmField
        val EXCEPTION = TeamListTopDelayException()
    }
}