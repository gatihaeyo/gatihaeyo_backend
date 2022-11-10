package com.project.gatihaeyo.internal.domain.exception.team

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.team.TeamErrorCode

class AlreadyInviteTeamException private constructor() : GlobalException(TeamErrorCode.ALREADY_INVITE_TEAM) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyInviteTeamException()
    }

}