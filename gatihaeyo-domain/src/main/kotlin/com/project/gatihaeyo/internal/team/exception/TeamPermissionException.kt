package com.project.gatihaeyo.internal.team.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.team.error.TeamErrorCode.TEAM_PERMISSION

class TeamPermissionException private constructor() : GlobalException(TEAM_PERMISSION) {

    companion object {
        val EXCEPTION = TeamPermissionException()
    }
}