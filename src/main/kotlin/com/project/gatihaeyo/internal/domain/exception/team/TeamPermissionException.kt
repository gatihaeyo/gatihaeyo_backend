package com.project.gatihaeyo.internal.domain.exception.team

import com.project.gatihaeyo.global.exception.GlobalException
import com.project.gatihaeyo.internal.domain.error.team.TeamErrorCode

class TeamPermissionException private constructor() : GlobalException(TeamErrorCode.TEAM_PERMISSION) {

    companion object {
        val EXCEPTION = TeamPermissionException()
    }
}