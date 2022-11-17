package com.project.gatihaeyo.internal.team.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.team.error.TeamErrorCode.ALREADY_APPLY_TEAM

class AlreadyApplyTeamException private constructor() : GlobalException(ALREADY_APPLY_TEAM) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyApplyTeamException()
    }

}