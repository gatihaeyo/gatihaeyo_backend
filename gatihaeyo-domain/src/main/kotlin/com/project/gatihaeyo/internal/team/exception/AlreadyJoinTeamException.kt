package com.project.gatihaeyo.internal.team.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.team.error.TeamErrorCode.ALREADY_JOIN_TEAM

class AlreadyJoinTeamException private constructor() : GlobalException(ALREADY_JOIN_TEAM) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyJoinTeamException()
    }

}