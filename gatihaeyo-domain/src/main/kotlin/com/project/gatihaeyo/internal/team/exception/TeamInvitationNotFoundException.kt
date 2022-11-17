package com.project.gatihaeyo.internal.team.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.team.error.TeamErrorCode.TEAM_INVITATION_NOT_FOUND

class TeamInvitationNotFoundException private constructor() : GlobalException(TEAM_INVITATION_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = TeamInvitationNotFoundException()
    }
}