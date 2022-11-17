package com.project.gatihaeyo.internal.team.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.team.error.TeamErrorCode.TEAM_MEMBER_NOT_FOUND

class TeamMemberNotFoundException private constructor() : GlobalException(TEAM_MEMBER_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = TeamMemberNotFoundException()
    }
}