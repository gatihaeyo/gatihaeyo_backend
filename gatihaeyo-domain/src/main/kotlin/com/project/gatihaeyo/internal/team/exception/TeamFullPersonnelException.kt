package com.project.gatihaeyo.internal.team.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.team.error.TeamErrorCode.TEAM_FULL_PERSONNEL

class TeamFullPersonnelException private constructor() : GlobalException(TEAM_FULL_PERSONNEL) {

    companion object {
        @JvmField
        val EXCEPTION = TeamFullPersonnelException()
    }
}