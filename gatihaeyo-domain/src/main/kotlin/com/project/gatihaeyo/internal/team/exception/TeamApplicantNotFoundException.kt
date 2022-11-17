package com.project.gatihaeyo.internal.team.exception

import com.project.gatihaeyo.global.GlobalException
import com.project.gatihaeyo.internal.team.error.TeamErrorCode.TEAM_APPLICANT_NOT_FOUND

class TeamApplicantNotFoundException private constructor() : GlobalException(TEAM_APPLICANT_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = TeamApplicantNotFoundException()
    }
}