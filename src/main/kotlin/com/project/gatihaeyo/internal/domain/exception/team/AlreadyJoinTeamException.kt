package com.project.gatihaeyo.internal.domain.exception.team

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.team.TeamErrorCode

class AlreadyJoinTeamException private constructor() : GlobalException(TeamErrorCode.ALREADY_JOIN_TEAM) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyJoinTeamException()
    }

}