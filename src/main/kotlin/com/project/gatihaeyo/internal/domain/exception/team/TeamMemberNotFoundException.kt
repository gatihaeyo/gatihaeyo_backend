package com.project.gatihaeyo.internal.domain.exception.team

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.team.TeamErrorCode

class TeamMemberNotFoundException private constructor() : GlobalException(TeamErrorCode.TEAM_MEMBER_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = TeamMemberNotFoundException()
    }
}