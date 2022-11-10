package com.project.gatihaeyo.internal.domain.exception.team

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.team.TeamErrorCode

class TeamFullPersonnelException private constructor() : GlobalException(TeamErrorCode.TEAM_FULL_PERSONNEL) {

    companion object {
        @JvmField
        val EXCEPTION = TeamFullPersonnelException()
    }
}