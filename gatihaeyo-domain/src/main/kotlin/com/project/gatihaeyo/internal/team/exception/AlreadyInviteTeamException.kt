package com.project.gatihaeyo.internal.team.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.team.error.TeamErrorCode.ALREADY_INVITE_TEAM

class AlreadyInviteTeamException private constructor() : GlobalException(ALREADY_INVITE_TEAM) {

    companion object {
        @JvmField
        val EXCEPTION = AlreadyInviteTeamException()
    }

}