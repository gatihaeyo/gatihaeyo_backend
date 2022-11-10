package com.project.gatihaeyo.internal.domain.exception.team

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.team.TeamErrorCode

class TeamMasterBreakawayException private constructor() : GlobalException(TeamErrorCode.TEAM_MASTER_BREAKAWAY) {

    companion object {
        @JvmField
        val EXCEPTION = TeamMasterBreakawayException()
    }

}