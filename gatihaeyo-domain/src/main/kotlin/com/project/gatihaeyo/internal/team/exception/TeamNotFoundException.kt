package com.project.gatihaeyo.internal.team.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.team.error.TeamErrorCode.TEAM_NOT_FOUND

class TeamNotFoundException private constructor() : GlobalException(TEAM_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = TeamNotFoundException()
    }

}