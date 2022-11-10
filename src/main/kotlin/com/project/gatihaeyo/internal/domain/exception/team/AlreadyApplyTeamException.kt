package com.project.gatihaeyo.internal.domain.exception.team

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.team.TeamErrorCode

class AlreadyApplyTeamException private constructor() : GlobalException(TeamErrorCode.ALREADY_APPLY_TEAM) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyApplyTeamException()
    }

}