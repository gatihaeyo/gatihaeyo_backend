package com.project.gatihaeyo.internal.team.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.team.error.TeamErrorCode.TEAM_MASTER_BREAKAWAY

class TeamMasterBreakawayException private constructor() : GlobalException(TEAM_MASTER_BREAKAWAY) {

    companion object {
        @JvmField
        val EXCEPTION = TeamMasterBreakawayException()
    }

}